package com.d365lab.eatery.restaurantcustomerorchestrator.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.simple.JSONObject;

import java.io.Serializable;
import java.util.Date;

public class RestaurantLoginStatus implements Serializable {
    private String restaurantUserName;
    private String restaurantOutletTenantId;
    private Integer restaurantUserLoginStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE MMM dd HH:mm:ss Z yyyy")
    private Date restaurantUserLastLoggedInAt;

    public RestaurantLoginStatus() {
    }

    public RestaurantLoginStatus(String restaurantUserName, String restaurantOutletTenantId, Integer restaurantUserLoginStatus, Date restaurantUserLastLoggedInAt) {
        this.restaurantUserName = restaurantUserName;
        this.restaurantOutletTenantId = restaurantOutletTenantId;
        this.restaurantUserLoginStatus = restaurantUserLoginStatus;
        this.restaurantUserLastLoggedInAt = restaurantUserLastLoggedInAt;
    }

    public String getRestaurantUserName() {
        return restaurantUserName;
    }

    public void setRestaurantUserName(String restaurantUserName) {
        this.restaurantUserName = restaurantUserName;
    }

    public String getRestaurantOutletTenantId() {
        return restaurantOutletTenantId;
    }

    public void setRestaurantOutletTenantId(String restaurantOutletTenantId) {
        this.restaurantOutletTenantId = restaurantOutletTenantId;
    }

    public Integer getRestaurantUserLoginStatus() {
        return restaurantUserLoginStatus;
    }

    public void setRestaurantUserLoginStatus(Integer restaurantUserLoginStatus) {
        this.restaurantUserLoginStatus = restaurantUserLoginStatus;
    }

    public Date getRestaurantUserLastLoggedInAt() {
        return restaurantUserLastLoggedInAt;
    }

    public void setRestaurantUserLastLoggedInAt(Date restaurantUserLastLoggedInAt) {
        this.restaurantUserLastLoggedInAt = restaurantUserLastLoggedInAt;
    }

    public static JSONObject toJSON(RestaurantLoginStatus restaurantLoginStatus) {
        JSONObject jo = new JSONObject();
        jo.put("restaurantUserName", restaurantLoginStatus.getRestaurantUserName());
        jo.put("restaurantOutletTenantId", restaurantLoginStatus.getRestaurantOutletTenantId());
        jo.put("restaurantUserLoginStatus", restaurantLoginStatus.getRestaurantUserLoginStatus().toString());
        jo.put("restaurantUserLastLoggedInAt", restaurantLoginStatus.getRestaurantUserLastLoggedInAt().toString());
        return jo;
    }
}
