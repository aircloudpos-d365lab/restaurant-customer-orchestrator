package com.d365lab.eatery.restaurantcustomerorchestrator.services;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantLogin;
import org.javatuples.Pair;

import java.util.List;

public interface RestaurantOnboardingService {

    String generateLogin(String userName, String userGivenPassword, String restaurant_master_tenant_id, String restaurant_outlet_tenant_id, String restaurant_brand_name, String restaurant_outlet_name);
    List<RestaurantLogin> verifyPassword(String userName, String password);
    List<RestaurantLogin> logoutRestaurant(String userName);
    Pair<String, String> generateTenant(String restaurantBrandName, String restaurantOutletName);
}
