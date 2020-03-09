package com.d365lab.eatery.restaurantcustomerorchestrator.services;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.RestaurantCustomerOrchestratorException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantOrchestratorService {
    List<RestaurantInfo> getAllRestaurantInfo();

    RestaurantDetails getRestaurantDetailsForRestaurant(String restaurantTenantId);

//    List<RestaurantMenu> getRestaurantMenuForRestaurant(String restaurantTenantId, Integer pageNo, Integer pageSize, String sortBy);

    List<RestaurantMenuCustomization> getAllRestaurantMenuCustomizationForMenu(Integer restaurantMenuId);

    void updatePhotoUrlForMenuForRestaurant(Integer restaurantMenuId, String menuPhotoUrl);

    List<RestaurantPaymentOptions> getRestaurantPaymentOptionsForRestaurant(String restaurantTenantId);

    RestaurantInfo addRestaurantInfoWithLogin(RestaurantInfo restaurantInfoPayload) throws RestaurantCustomerOrchestratorException;

    void updateRestaurantEmailInfoForRestaurant(String restaurantTenantId, String restaurantEmailId) throws RestaurantCustomerOrchestratorException;

    RestaurantMenuWithCustomization addRestaurantMenu(RestaurantMenuInputPayload restaurantMenuWithCustomizationPayload) throws RestaurantCustomerOrchestratorException, ParseException;

    RestaurantPaymentOptions addRestaurantPaymentOptions(RestaurantPaymentOptions restaurantPaymentOptionsPayload) throws RestaurantCustomerOrchestratorException;

    RestaurantMenuWithCustomization getRestaurantMenuForMenuNameAndTenant(Integer restaurantMenuId, String restaurantTenantId);

    RestaurantMenuWithCustomization updateRestaurantMenu(Integer restaurantMenuId, RestaurantMenuInputPayload restaurantMenuInputPayload) throws ParseException;

    RestaurantMenuWithCustomization getRestaurantMenuWithCustomizationForAMenuId(String restaurantMenuId);

    void resetRestaurantMenuToActivate(String restaurantMenuId);

    void setRestaurantMenuToDeactivate(String restaurantMenuId);

    List<Item> convertRestaurantMenuToCartMenu(List<RestaurantMenuWithCustomization> restaurantMenuList);

    RestaurantTenantDetails getOutletDetailsForMasterTenant(String restaurantMasterTenantId) throws RestaurantCustomerOrchestratorException;

//    TemporaryCartToPersistInRedis persistTemporaryCartIntoCache(TemporaryCartToPersistInRedis temporaryCartToPersistInRedis);
}
