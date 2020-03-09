package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;

public class Item implements Serializable {
    private Integer cartMenuId;
    private Integer cartId;
    private Integer cartRestaurantMenuId;
    private String cartRestaurantTenantId;
    private String cartRestaurantMenuName;
    private String cartRestaurantMenuDescription;
    private String cartRestaurantMenuType;
    private String cartRestaurantMenuCategory;
    private String cartRestaurantMenuPhoto;
    private String cartRestaurantMenuCustomization;
    private Double cartRestaurantMenuPrice;
    private Double cartRestaurantMenuPriceCgstPercentage;
    private Double cartRestaurantMenuPriceSgstPercentage;
    private Double cartRestaurantMenuRating;
    private Double cartRestaurantMenuFinalPrice;
    private Integer cartRestaurantMenuQty;
    private Integer cartRestaurantMenuIsDisabled;

    public Item() {
    }

    public Item(Integer cartMenuId, Integer cartId, Integer cartRestaurantMenuId, String cartRestaurantTenantId, String cartRestaurantMenuName, String cartRestaurantMenuDescription, String cartRestaurantMenuType, String cartRestaurantMenuCategory, String cartRestaurantMenuPhoto, String cartRestaurantMenuCustomization, Double cartRestaurantMenuPrice, Double cartRestaurantMenuPriceCgstPercentage, Double cartRestaurantMenuPriceSgstPercentage, Double cartRestaurantMenuRating, Double cartRestaurantMenuFinalPrice, Integer cartRestaurantMenuQty, Integer cartRestaurantMenuIsDisabled) {
        this.cartMenuId = cartMenuId;
        this.cartId = cartId;
        this.cartRestaurantMenuId = cartRestaurantMenuId;
        this.cartRestaurantTenantId = cartRestaurantTenantId;
        this.cartRestaurantMenuName = cartRestaurantMenuName;
        this.cartRestaurantMenuDescription = cartRestaurantMenuDescription;
        this.cartRestaurantMenuType = cartRestaurantMenuType;
        this.cartRestaurantMenuCategory = cartRestaurantMenuCategory;
        this.cartRestaurantMenuPhoto = cartRestaurantMenuPhoto;
        this.cartRestaurantMenuCustomization = cartRestaurantMenuCustomization;
        this.cartRestaurantMenuPrice = cartRestaurantMenuPrice;
        this.cartRestaurantMenuPriceCgstPercentage = cartRestaurantMenuPriceCgstPercentage;
        this.cartRestaurantMenuPriceSgstPercentage = cartRestaurantMenuPriceSgstPercentage;
        this.cartRestaurantMenuRating = cartRestaurantMenuRating;
        this.cartRestaurantMenuFinalPrice = cartRestaurantMenuFinalPrice;
        this.cartRestaurantMenuQty = cartRestaurantMenuQty;
        this.cartRestaurantMenuIsDisabled = cartRestaurantMenuIsDisabled;
    }

    public Integer getCartMenuId() {
        return cartMenuId;
    }

    public void setCartMenuId(Integer cartMenuId) {
        this.cartMenuId = cartMenuId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartRestaurantMenuId() {
        return cartRestaurantMenuId;
    }

    public void setCartRestaurantMenuId(Integer cartRestaurantMenuId) {
        this.cartRestaurantMenuId = cartRestaurantMenuId;
    }

    public String getCartRestaurantTenantId() {
        return cartRestaurantTenantId;
    }

    public void setCartRestaurantTenantId(String cartRestaurantTenantId) {
        this.cartRestaurantTenantId = cartRestaurantTenantId;
    }

    public String getCartRestaurantMenuName() {
        return cartRestaurantMenuName;
    }

    public void setCartRestaurantMenuName(String cartRestaurantMenuName) {
        this.cartRestaurantMenuName = cartRestaurantMenuName;
    }

    public String getCartRestaurantMenuDescription() {
        return cartRestaurantMenuDescription;
    }

    public void setCartRestaurantMenuDescription(String cartRestaurantMenuDescription) {
        this.cartRestaurantMenuDescription = cartRestaurantMenuDescription;
    }

    public String getCartRestaurantMenuType() {
        return cartRestaurantMenuType;
    }

    public void setCartRestaurantMenuType(String cartRestaurantMenuType) {
        this.cartRestaurantMenuType = cartRestaurantMenuType;
    }

    public String getCartRestaurantMenuCategory() {
        return cartRestaurantMenuCategory;
    }

    public void setCartRestaurantMenuCategory(String cartRestaurantMenuCategory) {
        this.cartRestaurantMenuCategory = cartRestaurantMenuCategory;
    }

    public String getCartRestaurantMenuPhoto() {
        return cartRestaurantMenuPhoto;
    }

    public void setCartRestaurantMenuPhoto(String cartRestaurantMenuPhoto) {
        this.cartRestaurantMenuPhoto = cartRestaurantMenuPhoto;
    }

    public Double getCartRestaurantMenuPrice() {
        return cartRestaurantMenuPrice;
    }

    public void setCartRestaurantMenuPrice(Double cartRestaurantMenuPrice) {
        this.cartRestaurantMenuPrice = cartRestaurantMenuPrice;
    }

    public Double getCartRestaurantMenuPriceCgstPercentage() {
        return cartRestaurantMenuPriceCgstPercentage;
    }

    public void setCartRestaurantMenuPriceCgstPercentage(Double cartRestaurantMenuPriceCgstPercentage) {
        this.cartRestaurantMenuPriceCgstPercentage = cartRestaurantMenuPriceCgstPercentage;
    }

    public Double getCartRestaurantMenuPriceSgstPercentage() {
        return cartRestaurantMenuPriceSgstPercentage;
    }

    public void setCartRestaurantMenuPriceSgstPercentage(Double cartRestaurantMenuPriceSgstPercentage) {
        this.cartRestaurantMenuPriceSgstPercentage = cartRestaurantMenuPriceSgstPercentage;
    }

    public Double getCartRestaurantMenuRating() {
        return cartRestaurantMenuRating;
    }

    public void setCartRestaurantMenuRating(Double cartRestaurantMenuRating) {
        this.cartRestaurantMenuRating = cartRestaurantMenuRating;
    }

    public Double getCartRestaurantMenuFinalPrice() {
        return cartRestaurantMenuFinalPrice;
    }

    public void setCartRestaurantMenuFinalPrice(Double cartRestaurantMenuFinalPrice) {
        this.cartRestaurantMenuFinalPrice = cartRestaurantMenuFinalPrice;
    }

    public Integer getCartRestaurantMenuQty() {
        return cartRestaurantMenuQty;
    }

    public void setCartRestaurantMenuQty(Integer cartRestaurantMenuQty) {
        this.cartRestaurantMenuQty = cartRestaurantMenuQty;
    }

    public String getCartRestaurantMenuCustomization() {
        return cartRestaurantMenuCustomization;
    }

    public void setCartRestaurantMenuCustomization(String cartRestaurantMenuCustomization) {
        this.cartRestaurantMenuCustomization = cartRestaurantMenuCustomization;
    }

    public Integer getCartRestaurantMenuIsDisabled() {
        return cartRestaurantMenuIsDisabled;
    }

    public void setCartRestaurantMenuIsDisabled(Integer cartRestaurantMenuIsDisabled) {
        this.cartRestaurantMenuIsDisabled = cartRestaurantMenuIsDisabled;
    }
}
