package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantOrder;

import java.io.Serializable;
import java.util.List;

public class RestaurantOrderOutputPayload implements Serializable {
    private RestaurantOrder restaurantOrder;
    private List<Item> orderMenuList;

    public RestaurantOrderOutputPayload() {
    }

    public RestaurantOrderOutputPayload(RestaurantOrder restaurantOrder, List<Item> orderMenuList) {
        this.restaurantOrder = restaurantOrder;
        this.orderMenuList = orderMenuList;
    }

    public RestaurantOrder getRestaurantOrder() {
        return restaurantOrder;
    }

    public void setRestaurantOrder(RestaurantOrder restaurantOrder) {
        this.restaurantOrder = restaurantOrder;
    }

    public List<Item> getOrderMenuList() {
        return orderMenuList;
    }

    public void setOrderMenuList(List<Item> orderMenuList) {
        this.orderMenuList = orderMenuList;
    }
}
