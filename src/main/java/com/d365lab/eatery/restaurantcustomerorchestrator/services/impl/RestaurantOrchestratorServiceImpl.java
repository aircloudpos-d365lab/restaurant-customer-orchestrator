package com.d365lab.eatery.restaurantcustomerorchestrator.services.impl;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.repositories.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOnboardingService;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrchestratorService;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.RestaurantCustomerOrchestratorException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.gson.JsonObject;
import org.javatuples.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.d365lab.eatery.restaurantcustomerorchestrator.utils.constants.RestaurantCustomerOrchestratorConstants.CACHE_INGESTION_MAX_RETRY_COUNT;

@Service
public class RestaurantOrchestratorServiceImpl implements RestaurantOrchestratorService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantOrchestratorServiceImpl.class);
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    @Autowired
    private RestaurantMenuCustomizationRepository restaurantMenuCustomizationRepository;

    @Autowired
    private RestaurantPaymentOptionsRepository restaurantPaymentOptionsRepository;

    @Autowired
    private RestaurantOnboardingService restaurantOnboardingService;


    @Override
    public List<RestaurantInfo> getAllRestaurantInfo() {
        return restaurantInfoRepository.findAll();
    }

    @Override
    public RestaurantDetails getRestaurantDetailsForRestaurant(String restaurantTenantId) {
        RestaurantDetails restaurantDetails = new RestaurantDetails();
        List<RestaurantMenuWithCustomization> menuWithCustomizationsListForRestaurant = new ArrayList<>();
        RestaurantInfo restaurantInfo = restaurantInfoRepository.findRestaurantInfoForRestaurant(restaurantTenantId);
        List<RestaurantPaymentOptions> restaurantPaymentOptionsList = restaurantPaymentOptionsRepository.findRestaurantPaymentOptionsForRestaurant(restaurantTenantId);
        List<RestaurantMenu> restaurantMenuList = restaurantMenuRepository.findAllMenusForRestaurant(restaurantTenantId);
        restaurantDetails.setRestaurantOutletTenantId(restaurantTenantId);
        restaurantDetails.setRestaurantBrandName(restaurantInfo.getRestaurantBrandName());
        restaurantDetails.setRestaurantMasterTenantId(restaurantInfo.getRestaurantMasterTenantId());
        restaurantDetails.setRestaurantOutletName(restaurantInfo.getRestaurantOutletName());
        restaurantDetails.setRestaurantAddress(restaurantInfo.getRestaurantAddress());
        restaurantDetails.setRestaurantContactNo(restaurantInfo.getRestaurantContactNo());
        restaurantDetails.setRestaurantEmail(restaurantInfo.getRestaurantEmail());
        restaurantDetails.setRestaurantBrandName(restaurantInfo.getRestaurantBrandName());
        restaurantDetails.setRestaurantPrimaryBankAccountNumber(restaurantInfo.getRestaurantPrimaryBankAccountNumber());
        restaurantDetails.setRestaurantPrimaryBankAccountBankName(restaurantInfo.getRestaurantPrimaryBankAccountBankName());
        restaurantDetails.setRestaurantPrimaryBankAccountHolderName(restaurantInfo.getRestaurantPrimaryBankAccountHolderName());
        restaurantDetails.setRestaurantPrimaryBankAccountIfsc(restaurantInfo.getRestaurantPrimaryBankAccountIfsc());
        restaurantDetails.setRestaurantSecondaryBankAccountNumber(restaurantInfo.getRestaurantSecondaryBankAccountNumber());
        restaurantDetails.setRestaurantSecondaryBankAccountBankName(restaurantInfo.getRestaurantSecondaryBankAccountBankName());
        restaurantDetails.setRestaurantSecondaryBankAccountHolderName(restaurantInfo.getRestaurantSecondaryBankAccountHolderName());
        restaurantDetails.setRestaurantSecondaryBankAccountIfsc(restaurantInfo.getRestaurantSecondaryBankAccountIfsc());
        restaurantDetails.setRestaurantLogo(restaurantInfo.getRestaurantLogo());
        restaurantMenuList.forEach(restaurantMenu -> {
            List<RestaurantMenuCustomization> restaurantMenuCustomizationList = restaurantMenuCustomizationRepository.findMenuCustomizationsForAMenuForARestaurant(restaurantTenantId, restaurantMenu.getRestaurantMenuId());
            RestaurantMenuWithCustomization restaurantMenuWithCustomization = new RestaurantMenuWithCustomization();
            restaurantMenuWithCustomization.setRestaurantMenu(restaurantMenu);
            restaurantMenuWithCustomization.setRestaurantMenuCustomizationList(restaurantMenuCustomizationList);
            menuWithCustomizationsListForRestaurant.add(restaurantMenuWithCustomization);
        });
        restaurantDetails.setMenuList(menuWithCustomizationsListForRestaurant);
        restaurantDetails.setRestaurantPaymentOptionsList(restaurantPaymentOptionsList);
        return restaurantDetails;
    }

//    @Override
//    public List<RestaurantMenu> getRestaurantMenuForRestaurant(String restaurantTenantId, Integer pageNo, Integer pageSize, String sortBy) {
//        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//        Page<RestaurantMenu> pagedResultForMenusForARestaurant = restaurantMenuRepository.findAllMenusForRestaurantWithPagination(restaurantTenantId, paging);
//
//        if (pagedResultForMenusForARestaurant.hasContent()) {
//            return pagedResultForMenusForARestaurant.getContent();
//        } else {
//            return new ArrayList<RestaurantMenu>();
//        }
//    }

    @Override
    public List<RestaurantPaymentOptions> getRestaurantPaymentOptionsForRestaurant(String restaurantTenantId) {
        return restaurantPaymentOptionsRepository.findRestaurantPaymentOptionsForRestaurant(restaurantTenantId);
    }

    @Override
    public RestaurantInfo addRestaurantInfoWithLogin(RestaurantInfo restaurantInfoPayload) throws RestaurantCustomerOrchestratorException {
        Pair<String, String> restaurantMasterOutletTenantIdPair = restaurantOnboardingService.generateTenant(restaurantInfoPayload.getRestaurantBrandName(),
                restaurantInfoPayload.getRestaurantOutletName());
        String loginCreationStatus = restaurantOnboardingService.generateLogin(restaurantInfoPayload.getRestaurantEmail(),
                "default@123",
                restaurantMasterOutletTenantIdPair.getValue0(),
                restaurantMasterOutletTenantIdPair.getValue1(),
                restaurantInfoPayload.getRestaurantBrandName(),
                restaurantInfoPayload.getRestaurantOutletName());
        if (loginCreationStatus.equalsIgnoreCase("SUCCESS")) {
            restaurantInfoPayload.setRestaurantMasterTenantId(restaurantMasterOutletTenantIdPair.getValue0());
            restaurantInfoPayload.setRestaurantOutletTenantId(restaurantMasterOutletTenantIdPair.getValue1());
            RestaurantInfo restaurantInfo = restaurantInfoRepository.findRestaurantInfoForRestaurant(restaurantMasterOutletTenantIdPair.getValue1());
            if (restaurantInfo == null) {
                return restaurantInfoRepository.save(restaurantInfoPayload);
            } else {
                throw new RestaurantCustomerOrchestratorException("Restaurant Info is already present for restaurant with tenant-id:" + restaurantInfo.getRestaurantOutletTenantId());
            }
        }
        else {
            throw new RestaurantCustomerOrchestratorException("Restaurant login failed to be created for restaurant: " + restaurantInfoPayload.getRestaurantBrandName() + "and outlet: " + restaurantInfoPayload.getRestaurantOutletName());
        }
    }

    @Override
    public void updateRestaurantEmailInfoForRestaurant(String restaurantTenantId, String restaurantEmailId) throws RestaurantCustomerOrchestratorException {
        RestaurantInfo restaurantInfo = restaurantInfoRepository.findRestaurantInfoForRestaurant(restaurantTenantId);
        RestaurantInfo restaurantUpdatedInfo = null;
        if (restaurantInfo == null) {
            throw new RestaurantCustomerOrchestratorException("Restaurant does not exist!");
        } else {
            restaurantInfoRepository.updateRestaurantEmailInfoForRestaurant(restaurantTenantId, restaurantEmailId);
        }
    }

    @Override
    public RestaurantMenuWithCustomization addRestaurantMenu(RestaurantMenuInputPayload restaurantMenuWithCustomizationPayload) throws RestaurantCustomerOrchestratorException, ParseException {
        RestaurantMenu restaurantMenuPayload = new RestaurantMenu();
        Integer retry =0;
        restaurantMenuPayload.setRestaurantTenantId(restaurantMenuWithCustomizationPayload.getRestaurantTenantId());
        restaurantMenuPayload.setRestaurantMenuName(restaurantMenuWithCustomizationPayload.getRestaurantMenuName());
        restaurantMenuPayload.setRestaurantMenuDescription(restaurantMenuWithCustomizationPayload.getRestaurantMenuDescription());
        restaurantMenuPayload.setRestaurantMenuType(restaurantMenuWithCustomizationPayload.getRestaurantMenuType());
        restaurantMenuPayload.setRestaurantMenuCategory(restaurantMenuWithCustomizationPayload.getRestaurantMenuCategory());
        restaurantMenuPayload.setRestaurantMenuPhoto(restaurantMenuWithCustomizationPayload.getRestaurantMenuPhoto());
        restaurantMenuPayload.setRestaurantMenuPrice(restaurantMenuWithCustomizationPayload.getRestaurantMenuPrice());
        restaurantMenuPayload.setRestaurantMenuPriceCgstPercentage(restaurantMenuWithCustomizationPayload.getRestaurantMenuPriceCgstPercentage());
        restaurantMenuPayload.setRestaurantMenuPriceSgstPercentage(restaurantMenuWithCustomizationPayload.getRestaurantMenuPriceSgstPercentage());
        restaurantMenuPayload.setRestaurantMenuRating(0.0);
        restaurantMenuPayload.setIsMenuDisabled(0);
        restaurantMenuPayload.setRestaurantMenuFinalPrice(
                Math.round(Double.sum(restaurantMenuPayload.getRestaurantMenuPrice(),
                        (restaurantMenuPayload.getRestaurantMenuPrice() * (Double.sum(
                                restaurantMenuPayload.getRestaurantMenuPriceCgstPercentage() / 100D,
                                restaurantMenuPayload.getRestaurantMenuPriceSgstPercentage() / 100D)))) * 100D
                ) / 100D);
        RestaurantMenu restaurantMenu = restaurantMenuRepository.save(restaurantMenuPayload);
        List<RestaurantMenuCustomization> menuCustomizationList = new ArrayList<>();
        if (restaurantMenu == null) {
            throw new RestaurantCustomerOrchestratorException("Could not create menu for the restaurant.");
        } else {
            if(restaurantMenuWithCustomizationPayload.getRestaurantMenuCustomizationList().length() > 0 &&
                    !restaurantMenuWithCustomizationPayload.getRestaurantMenuCustomizationList().equalsIgnoreCase(" ")) {
                Arrays.asList(restaurantMenuWithCustomizationPayload.getRestaurantMenuCustomizationList()
                        .split(","))
                        .forEach(menuCustomization -> {
                            RestaurantMenuCustomization restaurantMenuCustomization = new RestaurantMenuCustomization();
                            restaurantMenuCustomization.setRestaurantMenuId(restaurantMenu.getRestaurantMenuId());
                            restaurantMenuCustomization.setRestaurantTenantId(restaurantMenu.getRestaurantTenantId());
                            restaurantMenuCustomization.setRestaurantMenuCustomizationDescription(menuCustomization);
                            RestaurantMenuCustomization restaurantMenuCustomizationEntry = restaurantMenuCustomizationRepository.save(restaurantMenuCustomization);
                            if (restaurantMenuCustomizationEntry == null) {
                                try {
                                    throw new RestaurantCustomerOrchestratorException("Menu customization could not be created");
                                } catch (RestaurantCustomerOrchestratorException e) {
                                    LOGGER.error("Exception:{} occurred while creating menu-customization for menu:{}", e.getMessage(), restaurantMenu.getRestaurantMenuName());
                                }
                            } else {
                                menuCustomizationList.add(restaurantMenuCustomizationEntry);
                            }
                        });
            }
        }
        RestaurantMenuWithCustomization restaurantMenuWithCustomization = new RestaurantMenuWithCustomization(restaurantMenu, menuCustomizationList);
        JSONParser jsonParser = new JSONParser();
        JSONObject cacheEntity = null;
        Object obj = jsonParser.parse("{}");
        cacheEntity = (JSONObject) obj;
        while (retry <= CACHE_INGESTION_MAX_RETRY_COUNT) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(cacheEntity.toJSONString(), headers);
            String url = "http://13.233.89.218:8084/api/cache/menu/upload-menu-list-into-cache/" + restaurantMenuWithCustomizationPayload.getRestaurantTenantId();
//            String url = "http://localhost:8084/api/cache/menu/upload-menu-list-into-cache/" + restaurantMenuWithCustomizationPayload.getRestaurantTenantId();
            LOGGER.info("url: {}", url);
            String response = restTemplate.postForObject(url, cacheEntity, String.class);
            if (response.equalsIgnoreCase("\"Success\""))
                break;
            LOGGER.info("Response: {}", response);
            retry++;
            Uninterruptibles.sleepUninterruptibly(retry*30, TimeUnit.SECONDS);
        }
        return restaurantMenuWithCustomization;
    }

    @Override
    public RestaurantPaymentOptions addRestaurantPaymentOptions(RestaurantPaymentOptions restaurantPaymentOptionsPayload) throws RestaurantCustomerOrchestratorException {
        RestaurantPaymentOptions restaurantPaymentOptions = restaurantPaymentOptionsRepository.save(restaurantPaymentOptionsPayload);
        if (restaurantPaymentOptions != null) {
            return restaurantPaymentOptions;
        } else {
            throw new RestaurantCustomerOrchestratorException("Restaurant Payment-Options could not be created for restaurant with tenant-id:" + restaurantPaymentOptionsPayload.getRestaurantTenantId());
        }
    }

    @Override
    public RestaurantMenuWithCustomization getRestaurantMenuForMenuNameAndTenant(Integer restaurantMenuId, String restaurantTenantId) {
        RestaurantMenu existingRestaurantMenu = restaurantMenuRepository.findMenuOfARestaurantThroughId(restaurantMenuId, restaurantTenantId);
        List<RestaurantMenuCustomization> existingRestaurantMenuCustomization = restaurantMenuCustomizationRepository.findMenuCustomizationsForAMenuForARestaurant(existingRestaurantMenu.getRestaurantTenantId(),
                existingRestaurantMenu.getRestaurantMenuId());
        return new RestaurantMenuWithCustomization(existingRestaurantMenu,
                existingRestaurantMenuCustomization == null ? null : existingRestaurantMenuCustomization);
    }

    @Override
    public RestaurantMenuWithCustomization updateRestaurantMenu(Integer restaurantMenuId, RestaurantMenuInputPayload restaurantMenuInputPayload) throws ParseException {
        Integer retry = 0;
        List<RestaurantMenuCustomization> updatedMenuCustomizationList = new ArrayList<>();
        Double restaurantMenuFinalPrice = (Math.round(Double.sum(restaurantMenuInputPayload.getRestaurantMenuPrice(),
                (restaurantMenuInputPayload.getRestaurantMenuPrice() * (Double.sum(
                        restaurantMenuInputPayload.getRestaurantMenuPriceCgstPercentage() / 100D,
                        restaurantMenuInputPayload.getRestaurantMenuPriceSgstPercentage() / 100D)))) * 100D
        ) / 100D);
        restaurantMenuRepository.updateMenuOfARestaurant(restaurantMenuId,
                restaurantMenuInputPayload.getRestaurantTenantId(),
                restaurantMenuInputPayload.getRestaurantMenuName(),
                restaurantMenuInputPayload.getRestaurantMenuDescription(),
                restaurantMenuInputPayload.getRestaurantMenuType(),
                restaurantMenuInputPayload.getRestaurantMenuPrice(),
                restaurantMenuInputPayload.getRestaurantMenuCategory(),
                restaurantMenuInputPayload.getRestaurantMenuPhoto(),
                restaurantMenuInputPayload.getRestaurantMenuPriceCgstPercentage(),
                restaurantMenuInputPayload.getRestaurantMenuPriceSgstPercentage(),
                restaurantMenuFinalPrice);
        List<RestaurantMenuCustomization> existingRestaurantMenuCustomizationList = restaurantMenuCustomizationRepository.findMenuCustomizationsForAMenuForARestaurant(restaurantMenuInputPayload.getRestaurantTenantId(), restaurantMenuId);

        if (!existingRestaurantMenuCustomizationList.isEmpty()) {
            StringBuilder existingCustomizations = new StringBuilder();
            existingRestaurantMenuCustomizationList.stream().forEach(cust -> {
                existingCustomizations.append(cust.getRestaurantMenuCustomizationDescription());
                existingCustomizations.append(",");
            });
            if (existingCustomizations.toString().substring(0, (existingCustomizations.toString().length() - 1)).equalsIgnoreCase(restaurantMenuInputPayload.getRestaurantMenuCustomizationList())) {
                // Do nothing
                existingRestaurantMenuCustomizationList.stream().forEach(menuCustomization -> {
                    updatedMenuCustomizationList.add(menuCustomization);
                });
                LOGGER.info("Menu-Customizations are same as earlier!");
            } else {
                LOGGER.info("Existing customization-List: {}", existingCustomizations.toString());
                restaurantMenuCustomizationRepository.deleteExistingMenuCustomizationForAMenuForARestaurant(restaurantMenuId, restaurantMenuInputPayload.getRestaurantTenantId());

                if (restaurantMenuInputPayload.getRestaurantMenuCustomizationList().length() > 0 &&
                        !restaurantMenuInputPayload.getRestaurantMenuCustomizationList().equalsIgnoreCase(" ")) {
                    Arrays.asList(restaurantMenuInputPayload.getRestaurantMenuCustomizationList()
                            .split(","))
                            .forEach(menuCustomization -> {
                                RestaurantMenuCustomization restaurantMenuCustomization = new RestaurantMenuCustomization();
                                restaurantMenuCustomization.setRestaurantMenuId(restaurantMenuId);
                                restaurantMenuCustomization.setRestaurantTenantId(restaurantMenuInputPayload.getRestaurantTenantId());
                                restaurantMenuCustomization.setRestaurantMenuCustomizationDescription(menuCustomization);
                                updatedMenuCustomizationList.add(restaurantMenuCustomization);
                            });
                    Iterable<RestaurantMenuCustomization> iterableCustomizationList = updatedMenuCustomizationList;
                    List<RestaurantMenuCustomization> restaurantMenuCustomizationEntryList = restaurantMenuCustomizationRepository.saveAll(iterableCustomizationList);
                    if (restaurantMenuCustomizationEntryList == null) {
                        try {
                            throw new RestaurantCustomerOrchestratorException("Menu customization could not be created");
                        } catch (RestaurantCustomerOrchestratorException e) {
                            LOGGER.error("Exception:{} occurred while creating menu-customization for menu:{}", e.getMessage(), restaurantMenuInputPayload.getRestaurantMenuName());
                        }
                    } else {
                        // Do Nothing
                    }
                }
            }
        }
        else {
            if (restaurantMenuInputPayload.getRestaurantMenuCustomizationList().length() > 0 &&
                    !restaurantMenuInputPayload.getRestaurantMenuCustomizationList().equalsIgnoreCase(" ")) {
                Arrays.asList(restaurantMenuInputPayload.getRestaurantMenuCustomizationList()
                        .split(","))
                        .forEach(menuCustomization -> {
                            RestaurantMenuCustomization restaurantMenuCustomization = new RestaurantMenuCustomization();
                            restaurantMenuCustomization.setRestaurantMenuId(restaurantMenuId);
                            restaurantMenuCustomization.setRestaurantTenantId(restaurantMenuInputPayload.getRestaurantTenantId());
                            restaurantMenuCustomization.setRestaurantMenuCustomizationDescription(menuCustomization);
                            updatedMenuCustomizationList.add(restaurantMenuCustomization);
                        });
                Iterable<RestaurantMenuCustomization> iterableCustomizationList = updatedMenuCustomizationList;
                List<RestaurantMenuCustomization> restaurantMenuCustomizationEntryList = restaurantMenuCustomizationRepository.saveAll(iterableCustomizationList);
                if (restaurantMenuCustomizationEntryList == null) {
                    try {
                        throw new RestaurantCustomerOrchestratorException("Menu customization could not be created");
                    } catch (RestaurantCustomerOrchestratorException e) {
                        LOGGER.error("Exception:{} occurred while creating menu-customization for menu:{}", e.getMessage(), restaurantMenuInputPayload.getRestaurantMenuName());
                    }
                } else {
                    // Do Nothing
                }
            }
        }
//            else {
//                if(restaurantMenuInputPayload.getRestaurantMenuCustomizationList().length() > 0 &&
//                        !restaurantMenuInputPayload.getRestaurantMenuCustomizationList().equalsIgnoreCase(" ")) {
//                    Arrays.asList(restaurantMenuInputPayload.getRestaurantMenuCustomizationList().split("\\s*,\\s*")).stream()
//                            .forEach(customization -> {
//                                if (!existingCustomizations.toString().substring(0, (existingCustomizations.toString().length() - 1)).contains(customization)) {
//                                    RestaurantMenuCustomization addedRestaurantMenuCustomization = restaurantMenuCustomizationRepository.save(new RestaurantMenuCustomization(restaurantMenuInputPayload.getRestaurantTenantId(),
//                                            restaurantMenuId,
//                                            customization));
//                                } else {
//                                    Integer existingCustomizationId = restaurantMenuCustomizationRepository.findMenuCustomizationIdForAMenuForARestaurant(restaurantMenuId, restaurantMenuInputPayload.getRestaurantTenantId(), customization);
//                                    restaurantMenuCustomizationRepository.updateMenuCustomization(existingCustomizationId,
//                                            restaurantMenuId,
//                                            restaurantMenuInputPayload.getRestaurantTenantId(),
//                                            customization);
//                                }
//                            });
//                }
//            }
//        }
//        else {
//            if(restaurantMenuInputPayload.getRestaurantMenuCustomizationList().length() > 0 &&
//                    !restaurantMenuInputPayload.getRestaurantMenuCustomizationList().equalsIgnoreCase(" ")) {
//                Arrays.asList(restaurantMenuInputPayload.getRestaurantMenuCustomizationList().split("\\s*,\\s*")).stream()
//                        .forEach(customization -> {
//                            RestaurantMenuCustomization addedRestaurantMenuCustomization = restaurantMenuCustomizationRepository.save(new RestaurantMenuCustomization(restaurantMenuInputPayload.getRestaurantTenantId(),
//                                    restaurantMenuId,
//                                    customization));
//                        });
//            }
//        }
        JSONParser jsonParser = new JSONParser();
        JSONObject cacheEntity = null;
        Object obj = jsonParser.parse("{}");
        cacheEntity = (JSONObject) obj;
        while (retry <= CACHE_INGESTION_MAX_RETRY_COUNT) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(cacheEntity.toJSONString(), headers);
            String url = "http://13.233.89.218:8084/api/cache/menu/upload-menu-list-into-cache/" + restaurantMenuInputPayload.getRestaurantTenantId();
//            String url = "http://localhost:8084/api/cache/menu/upload-menu-list-into-cache/" + restaurantMenuInputPayload.getRestaurantTenantId();
            LOGGER.info("url: {}", url);
            String response = restTemplate.postForObject(url, cacheEntity, String.class);
            if (response.equalsIgnoreCase("\"Success\""))
                break;
            LOGGER.info("Response: {}", response);
            retry++;
            Uninterruptibles.sleepUninterruptibly(retry*30, TimeUnit.SECONDS);
        }
        return new RestaurantMenuWithCustomization(new RestaurantMenu(restaurantMenuInputPayload.getRestaurantMenuId(),
                restaurantMenuInputPayload.getRestaurantTenantId(),
                restaurantMenuInputPayload.getRestaurantMenuName(),
                restaurantMenuInputPayload.getRestaurantMenuDescription(),
                restaurantMenuInputPayload.getRestaurantMenuType(),
                restaurantMenuInputPayload.getRestaurantMenuCategory(),
                restaurantMenuInputPayload.getRestaurantMenuPhoto(),
                restaurantMenuInputPayload.getRestaurantMenuPrice(),
                restaurantMenuInputPayload.getRestaurantMenuPriceCgstPercentage(),
                restaurantMenuInputPayload.getRestaurantMenuPriceSgstPercentage(),
                0.0, restaurantMenuFinalPrice), updatedMenuCustomizationList);
    }

    @Override
    public RestaurantMenuWithCustomization getRestaurantMenuWithCustomizationForAMenuId(String restaurantMenuId) {
        RestaurantMenu existingRestaurantMenu = restaurantMenuRepository.findByMenuId(Integer.parseInt(restaurantMenuId));
        if (existingRestaurantMenu != null) {
            List<RestaurantMenuCustomization> existingRestaurantMenuCustomization = restaurantMenuCustomizationRepository.findMenuCustomizationsForAMenuForARestaurant(existingRestaurantMenu.getRestaurantTenantId(),
                    Integer.parseInt(restaurantMenuId));
            return new RestaurantMenuWithCustomization(existingRestaurantMenu, existingRestaurantMenuCustomization);
        }
        else {
            return null;
        }
    }

    @Override
    public void resetRestaurantMenuToActivate(String restaurantMenuId) {
        restaurantMenuRepository.resetToEnableMenu(restaurantMenuId);
    }

    @Override
    public void setRestaurantMenuToDeactivate(String restaurantMenuId) {
        restaurantMenuRepository.setToDisableMenu(restaurantMenuId);
    }

    @Override
    public List<Item> convertRestaurantMenuToCartMenu(List<RestaurantMenuWithCustomization> restaurantMenuList) {
        List<Item> initializedCartWithMenu = new ArrayList<>();
        List<String> menuCustomizationList = new ArrayList<>();
        restaurantMenuList.stream().forEach(menu -> {
            Item cartItem = new Item();
            menu.getRestaurantMenuCustomizationList().stream().forEach(cust -> {
                menuCustomizationList.add(cust.getRestaurantMenuCustomizationDescription());
            });
            String menuCustomizationListString = String.join(",", menuCustomizationList);
            cartItem.setCartId(0);
            cartItem.setCartMenuId(0);
            cartItem.setCartRestaurantMenuId(menu.getRestaurantMenu().getRestaurantMenuId());
            cartItem.setCartRestaurantTenantId(menu.getRestaurantMenu().getRestaurantTenantId());
            cartItem.setCartRestaurantMenuName(menu.getRestaurantMenu().getRestaurantMenuName());
            cartItem.setCartRestaurantMenuDescription(menu.getRestaurantMenu().getRestaurantMenuDescription());
            cartItem.setCartRestaurantMenuType(menu.getRestaurantMenu().getRestaurantMenuType());
            cartItem.setCartRestaurantMenuCategory(menu.getRestaurantMenu().getRestaurantMenuCategory());
            cartItem.setCartRestaurantMenuPhoto(menu.getRestaurantMenu().getRestaurantMenuPhoto());
            cartItem.setCartRestaurantMenuCustomization(menuCustomizationListString);
            cartItem.setCartRestaurantMenuPrice(menu.getRestaurantMenu().getRestaurantMenuPrice());
            cartItem.setCartRestaurantMenuPriceCgstPercentage(menu.getRestaurantMenu().getRestaurantMenuPriceCgstPercentage());
            cartItem.setCartRestaurantMenuPriceSgstPercentage(menu.getRestaurantMenu().getRestaurantMenuPriceSgstPercentage());
            cartItem.setCartRestaurantMenuRating(menu.getRestaurantMenu().getRestaurantMenuRating() == null ? 0 : menu.getRestaurantMenu().getRestaurantMenuRating());
            cartItem.setCartRestaurantMenuFinalPrice(menu.getRestaurantMenu().getRestaurantMenuFinalPrice());
            cartItem.setCartRestaurantMenuQty(0);
            cartItem.setCartRestaurantMenuIsDisabled(menu.getRestaurantMenu().getIsMenuDisabled());
            initializedCartWithMenu.add(cartItem);
        });
        return initializedCartWithMenu;
    }

    @Override
    public RestaurantTenantDetails getOutletDetailsForMasterTenant(String restaurantMasterTenantId) throws RestaurantCustomerOrchestratorException {
        List<RestaurantInfo> restaurantOutletList = new ArrayList<>();
        try {
            if (restaurantMasterTenantId == null || restaurantMasterTenantId.isEmpty()) {
                throw new RestaurantCustomerOrchestratorException("Restaurant-Master-Tenant-Id should not be empty or null!");
            } else {
                restaurantOutletList = restaurantInfoRepository.findTenantsOfARestaurant(restaurantMasterTenantId);
                RestaurantTenantDetails restaurantTenantDetails = new RestaurantTenantDetails(restaurantOutletList);
                if (restaurantTenantDetails == null || restaurantTenantDetails.getRestaurantTenantList().isEmpty()) {
                    return null;
                } else {
                    return restaurantTenantDetails;
                }
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception: {} occurred while fetching outlet-details for restaurant-master-tenant: {}", e.getMessage(), restaurantMasterTenantId);
            throw new RestaurantCustomerOrchestratorException(e.getMessage());
        }

    }

//    @Override
//    public TemporaryCartToPersistInRedis persistTemporaryCartIntoCache(TemporaryCartToPersistInRedis temporaryCartToPersistInRedis) {
//        return temporaryCartBeforeCheckoutRepository.save(temporaryCartToPersistInRedis);
//    }

    @Override
    public List<RestaurantMenuCustomization> getAllRestaurantMenuCustomizationForMenu(Integer restaurantMenuId) {
        return restaurantMenuCustomizationRepository.findAllMenuCustomizationsForRestaurant(restaurantMenuId);
    }

    @Override
    public void updatePhotoUrlForMenuForRestaurant(Integer restaurantMenuId, String menuPhotoUrl) {
        restaurantMenuRepository.updateMenuPhotoUrlForMenuForARestaurant(menuPhotoUrl, restaurantMenuId);
    }


}
