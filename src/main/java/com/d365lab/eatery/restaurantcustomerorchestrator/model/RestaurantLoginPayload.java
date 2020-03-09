package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;

public class RestaurantLoginPayload implements Serializable {

    private String restaurantUsername;
    private String restaurantPassword;

    public RestaurantLoginPayload() {
    }

    public RestaurantLoginPayload(String restaurantUsername, String restaurantPassword) {
        this.restaurantUsername = restaurantUsername;
        this.restaurantPassword = restaurantPassword;
    }

    public String getRestaurantUsername() {
        return restaurantUsername;
    }

    public void setRestaurantUsername(String restaurantUsername) {
        this.restaurantUsername = restaurantUsername;
    }

    public String getRestaurantPassword() {
        return restaurantPassword;
    }

    public void setRestaurantPassword(String restaurantPassword) {
        this.restaurantPassword = restaurantPassword;
    }
}
