package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantInfo;

import java.io.Serializable;
import java.util.List;

public class RestaurantTenantDetails implements Serializable {
    List<RestaurantInfo> restaurantTenantList;

    public RestaurantTenantDetails() {
    }

    public RestaurantTenantDetails(List<RestaurantInfo> restaurantTenantList) {
        this.restaurantTenantList = restaurantTenantList;
    }

    public List<RestaurantInfo> getRestaurantTenantList() {
        return restaurantTenantList;
    }

    public void setRestaurantTenantList(List<RestaurantInfo> restaurantTenantList) {
        this.restaurantTenantList = restaurantTenantList;
    }
}
