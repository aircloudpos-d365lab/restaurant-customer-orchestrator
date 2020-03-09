package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;
import java.util.List;

public class RestaurantOrderDetails implements Serializable {

    List<RestaurantOrderOutputPayload> restaurantOrderOutputPayloadList;

    public RestaurantOrderDetails() {
    }

    public RestaurantOrderDetails(List<RestaurantOrderOutputPayload> restaurantOrderOutputPayloadList) {
        this.restaurantOrderOutputPayloadList = restaurantOrderOutputPayloadList;
    }

    public List<RestaurantOrderOutputPayload> getRestaurantOrderOutputPayloadList() {
        return restaurantOrderOutputPayloadList;
    }

    public void setRestaurantOrderOutputPayloadList(List<RestaurantOrderOutputPayload> restaurantOrderOutputPayloadList) {
        this.restaurantOrderOutputPayloadList = restaurantOrderOutputPayloadList;
    }
}
