package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;

public class RestaurantMenuOutputPayload implements Serializable {

    private Integer restaurantMenuId;
    private String restaurantTenantId;
    private String restaurantMenuName;
    private String restaurantMenuDescription;
    private String restaurantMenuType;
    private String restaurantMenuCategory;
    private String restaurantMenuPhoto;
    private Double restaurantMenuPrice;
    private Double restaurantMenuPriceCgstPercentage;
    private Double restaurantMenuPriceSgstPercentage;
    private String restaurantMenuCustomizationList;

    public RestaurantMenuOutputPayload() {
    }

    public RestaurantMenuOutputPayload(Integer restaurantMenuId, String restaurantTenantId, String restaurantMenuName, String restaurantMenuDescription, String restaurantMenuType, String restaurantMenuCategory, String restaurantMenuPhoto, Double restaurantMenuPrice, Double restaurantMenuPriceCgstPercentage, Double restaurantMenuPriceSgstPercentage, String restaurantMenuCustomizationList) {
        this.restaurantMenuId = restaurantMenuId;
        this.restaurantTenantId = restaurantTenantId;
        this.restaurantMenuName = restaurantMenuName;
        this.restaurantMenuDescription = restaurantMenuDescription;
        this.restaurantMenuType = restaurantMenuType;
        this.restaurantMenuCategory = restaurantMenuCategory;
        this.restaurantMenuPhoto = restaurantMenuPhoto;
        this.restaurantMenuPrice = restaurantMenuPrice;
        this.restaurantMenuPriceCgstPercentage = restaurantMenuPriceCgstPercentage;
        this.restaurantMenuPriceSgstPercentage = restaurantMenuPriceSgstPercentage;
        this.restaurantMenuCustomizationList = restaurantMenuCustomizationList;
    }

    public Integer getRestaurantMenuId() {
        return restaurantMenuId;
    }

    public void setRestaurantMenuId(Integer restaurantMenuId) {
        this.restaurantMenuId = restaurantMenuId;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }

    public String getRestaurantMenuName() {
        return restaurantMenuName;
    }

    public void setRestaurantMenuName(String restaurantMenuName) {
        this.restaurantMenuName = restaurantMenuName;
    }

    public String getRestaurantMenuDescription() {
        return restaurantMenuDescription;
    }

    public void setRestaurantMenuDescription(String restaurantMenuDescription) {
        this.restaurantMenuDescription = restaurantMenuDescription;
    }

    public String getRestaurantMenuType() {
        return restaurantMenuType;
    }

    public void setRestaurantMenuType(String restaurantMenuType) {
        this.restaurantMenuType = restaurantMenuType;
    }

    public String getRestaurantMenuCategory() {
        return restaurantMenuCategory;
    }

    public void setRestaurantMenuCategory(String restaurantMenuCategory) {
        this.restaurantMenuCategory = restaurantMenuCategory;
    }

    public String getRestaurantMenuPhoto() {
        return restaurantMenuPhoto;
    }

    public void setRestaurantMenuPhoto(String restaurantMenuPhoto) {
        this.restaurantMenuPhoto = restaurantMenuPhoto;
    }

    public Double getRestaurantMenuPrice() {
        return restaurantMenuPrice;
    }

    public void setRestaurantMenuPrice(Double restaurantMenuPrice) {
        this.restaurantMenuPrice = restaurantMenuPrice;
    }

    public Double getRestaurantMenuPriceCgstPercentage() {
        return restaurantMenuPriceCgstPercentage;
    }

    public void setRestaurantMenuPriceCgstPercentage(Double restaurantMenuPriceCgstPercentage) {
        this.restaurantMenuPriceCgstPercentage = restaurantMenuPriceCgstPercentage;
    }

    public Double getRestaurantMenuPriceSgstPercentage() {
        return restaurantMenuPriceSgstPercentage;
    }

    public void setRestaurantMenuPriceSgstPercentage(Double restaurantMenuPriceSgstPercentage) {
        this.restaurantMenuPriceSgstPercentage = restaurantMenuPriceSgstPercentage;
    }

    public String getRestaurantMenuCustomizationList() {
        return restaurantMenuCustomizationList;
    }

    public void setRestaurantMenuCustomizationList(String restaurantMenuCustomizationList) {
        this.restaurantMenuCustomizationList = restaurantMenuCustomizationList;
    }
}