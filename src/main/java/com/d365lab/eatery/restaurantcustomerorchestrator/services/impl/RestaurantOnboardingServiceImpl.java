package com.d365lab.eatery.restaurantcustomerorchestrator.services.impl;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantLogin;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantLoginStatus;
import com.d365lab.eatery.restaurantcustomerorchestrator.repositories.RestaurantLoginRepository;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOnboardingService;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.restaurantlogin.PasswordUtils;
import com.google.common.util.concurrent.Uninterruptibles;
import org.apache.commons.lang3.RandomStringUtils;
import org.javatuples.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.d365lab.eatery.restaurantcustomerorchestrator.utils.constants.RestaurantCustomerOrchestratorConstants.CACHE_INGESTION_MAX_RETRY_COUNT;

@Service
public class RestaurantOnboardingServiceImpl implements RestaurantOnboardingService {

    @Autowired
    private RestaurantLoginRepository restaurantLoginRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantOnboardingServiceImpl.class);
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String generateLogin(String userName, String userGivenPassword, String restaurant_master_tenant_id, String restaurant_outlet_tenant_id, String restaurant_brand_name, String restaurant_outlet_name) {
        List<RestaurantLogin> existingRestaurantLoginList = restaurantLoginRepository.findRestaurantLoginForARestaurant(userName);
        // Generate Salt. The generated value can be stored in DB.
        String salt = PasswordUtils.getSalt(30);
        // Protect user's password. The generated value can be stored in DB.
        String securePassword = PasswordUtils.generateSecurePassword(userGivenPassword, salt);
        if (existingRestaurantLoginList.isEmpty()) {
            // Persist Username, Salt and Secured-Password in database
            RestaurantLogin restaurantLogin = restaurantLoginRepository.save(new RestaurantLogin(userName, securePassword, salt, restaurant_master_tenant_id, restaurant_outlet_tenant_id, restaurant_brand_name, restaurant_outlet_name, 0, null));
            if (restaurantLogin == null)
                return "FAILURE";
            else
                return "SUCCESS";
        }
        else {
            existingRestaurantLoginList.stream().forEach(existingRestaurantLogin -> {
                restaurantLoginRepository.updateLoginForRestaurant(existingRestaurantLogin.getRestaurantLoginId(), existingRestaurantLogin.getRestaurantUsername(), salt, securePassword);
                });
            }
        return "SUCCESS";
    }

    @Override
    public List<RestaurantLogin> verifyPassword(String userName, String password) {
        // Get Encoded password and salt value from database
        List<RestaurantLogin> restaurantLoginList = restaurantLoginRepository.findRestaurantLoginForARestaurant(userName);
        // Encrypted and Base64 encoded password read from database
        String securePassword = restaurantLoginList.get(0).getRestaurantEncryptedPassword(); //"HhaNvzTsVYwS/x/zbYXlLOE3ETMXQgllqrDaJY9PD/U=";
        // Salt value stored in database
        String salt = restaurantLoginList.get(0).getRestaurantSalt(); //"EqdmPh53c9x33EygXpTpcoJvc4VXLK";
        boolean passwordMatch = PasswordUtils.verifyUserPassword(password, securePassword, salt);
        if(passwordMatch) {
            restaurantLoginList.stream().forEach(rl -> {
                restaurantLoginRepository.updateLoggedInFlagAndLoggedInTimestampForRestaurant(rl.getRestaurantLoginId(), new Date());
                try {
                    updateLoginCacheForRestaurantLogin(restaurantLoginList.get(0).getRestaurantOutletTenantId(),
                            restaurantLoginList.get(0).getRestaurantUsername(),
                            1);
                } catch (ParseException e) {
                    LOGGER.error("Exception: {} occurred while adding login-status in Cache", e.getMessage());
                }
            });
            return restaurantLoginList;
        }
        else
            return null;
    }

    private void updateLoginCacheForRestaurantLogin(String restaurantOutletTenantId, String restaurantUsername, int i) throws ParseException {
        int retry = 0;
        JSONParser jsonParser = new JSONParser();
        JSONObject cacheEntity = null;
        RestaurantLoginStatus obj = new RestaurantLoginStatus(restaurantOutletTenantId,
                restaurantUsername,
                i,
                new Date());
        cacheEntity = RestaurantLoginStatus.toJSON(obj);
        while (retry <= CACHE_INGESTION_MAX_RETRY_COUNT) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<String> entity = new HttpEntity<String>(cacheEntity.toJSONString(), headers);
            String url = "http://13.233.89.218:8084/api/cache/login/status/" + restaurantOutletTenantId + "_" + restaurantUsername;
//            String url = "http://localhost:8084/api/cache/login/status/" + restaurantOutletTenantId + "_" + restaurantUsername;
            LOGGER.info("url: {}", url);
            ResponseEntity<RestaurantLoginStatus> restaurantLoginStatus = restTemplate.getForEntity(url, RestaurantLoginStatus.class);
            if (restaurantLoginStatus.getBody() == null) {
                String addUrl = "http://13.233.89.218:8084/api/cache/login/status/add/" + restaurantOutletTenantId + "_" + restaurantUsername;
                String response = restTemplate.postForObject(addUrl, cacheEntity, String.class);
                if (response.equalsIgnoreCase("\"Success\""))
                    break;
                LOGGER.info("Response: {}", response);
                retry++;
                Uninterruptibles.sleepUninterruptibly(retry * 30, TimeUnit.SECONDS);
            }
            else {
                String updateUrl = "http://13.233.89.218:8084/api/cache/login/status/update/" + restaurantOutletTenantId + "_" + restaurantUsername;
                String response = restTemplate.postForObject(updateUrl, cacheEntity, String.class);
                if (response.equalsIgnoreCase("\"Success\""))
                    break;
                LOGGER.info("Response: {}", response);
                retry++;
                Uninterruptibles.sleepUninterruptibly(retry * 30, TimeUnit.SECONDS);
            }
        }
    }

    @Override
    public List<RestaurantLogin> logoutRestaurant(String userName) {
        // Get Encoded password and salt value from database
        List<RestaurantLogin> restaurantLoginList = restaurantLoginRepository.findLoggedInRestaurant(userName);
        restaurantLoginList.stream().forEach(rld -> {
            restaurantLoginRepository.updateLoggedOutForRestaurant(rld.getRestaurantLoginId());
            try {
                updateLoginCacheForRestaurantLogin(restaurantLoginList.get(0).getRestaurantOutletTenantId(),
                        restaurantLoginList.get(0).getRestaurantUsername(),
                        0);
            } catch (ParseException e) {
                LOGGER.error("Exception: {} occurred while updating logout-status in Cache", e.getMessage());
            }
        });
        return restaurantLoginList;
    }

    @Override
    public Pair<String, String> generateTenant(String restaurantBrandName, String restaurantOutletName) {
        boolean doesExist = false;
        List<RestaurantLogin> existingTenantsForCurrentBrand = restaurantLoginRepository.findTenantsForARestaurantBrand(restaurantBrandName);
        if (existingTenantsForCurrentBrand.isEmpty()) {
            int length = 10;
            boolean useLetters = true;
            boolean useNumbers = false;
            String generatedMasterTenantId = "R" + RandomStringUtils.random(length, useLetters, useNumbers);
            List<RestaurantLogin> existingLoginDetailsForThisMasterTenantId = restaurantLoginRepository.findRestaurantLoginForAGivenMasterTenantId(generatedMasterTenantId);
            if (!existingLoginDetailsForThisMasterTenantId.isEmpty()) {
                doesExist = true;
                String newlyGeneratedMasterTenantId = null;
                List<RestaurantLogin> checkLoginDetailsForThisMasterTenantId = new ArrayList<>();
                while (doesExist) {
                    newlyGeneratedMasterTenantId = "R" + RandomStringUtils.random(length, useLetters, useNumbers);
                    checkLoginDetailsForThisMasterTenantId = restaurantLoginRepository.findRestaurantLoginForAGivenMasterTenantId(newlyGeneratedMasterTenantId);
                    if (checkLoginDetailsForThisMasterTenantId.isEmpty())
                        doesExist = false;
                }
                return new Pair<>(newlyGeneratedMasterTenantId, newlyGeneratedMasterTenantId + "_1");
            } else {
                return new Pair<>(generatedMasterTenantId, generatedMasterTenantId + "_1");
            }
        }
        else {
            return new Pair<>(existingTenantsForCurrentBrand.get(0).getRestaurantMasterTenantId(),
                    existingTenantsForCurrentBrand.get(0).getRestaurantMasterTenantId() + "_" + String.valueOf(existingTenantsForCurrentBrand.size() + 1));
        }
    }
}
