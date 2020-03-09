package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenu;
import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenuCustomization;

import java.io.Serializable;
import java.util.List;

public class RestaurantMenuWithCustomization implements Serializable {

    private RestaurantMenu restaurantMenu;
    private List<RestaurantMenuCustomization> restaurantMenuCustomizationList;

    public RestaurantMenuWithCustomization() {
    }

    public RestaurantMenuWithCustomization(RestaurantMenu restaurantMenu, List<RestaurantMenuCustomization> restaurantMenuCustomizationList) {
        this.restaurantMenu = restaurantMenu;
        this.restaurantMenuCustomizationList = restaurantMenuCustomizationList;
    }

    public RestaurantMenu getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    public List<RestaurantMenuCustomization> getRestaurantMenuCustomizationList() {
        return restaurantMenuCustomizationList;
    }

    public void setRestaurantMenuCustomizationList(List<RestaurantMenuCustomization> restaurantMenuCustomizationList) {
        this.restaurantMenuCustomizationList = restaurantMenuCustomizationList;
    }
}
