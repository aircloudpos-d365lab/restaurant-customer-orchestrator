package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cart implements Serializable {

    private String restaurantTenantId;
    private String customerTenantId;
    private List<Item> cartMenuList;
    private Integer isOrderPlaced;
    private String couponAppliedOnCart;
    private Double cartTotal;
    private Double cartDeliveryFee;
    private Double cartDiscountTotal;
    private Double cartGrandTotal;
    private Double cartItemPriceTotal;
    private Double cartTotalCgstPercentage;
    private Double cartTotalSgstPercentage;
    private Date createdAt;
    private Date updatedAt;

    public Cart() {
    }

    public Cart(String restaurantTenantId, String customerTenantId, List<Item> cartMenuList, Integer isOrderPlaced, String couponAppliedOnCart, Double cartTotal, Double cartDeliveryFee, Double cartDiscountTotal, Double cartGrandTotal, Double cartItemPriceTotal, Double cartTotalCgstPercentage, Double cartTotalSgstPercentage) {
        this.restaurantTenantId = restaurantTenantId;
        this.customerTenantId = customerTenantId;
        this.cartMenuList = cartMenuList;
        this.isOrderPlaced = isOrderPlaced;
        this.couponAppliedOnCart = couponAppliedOnCart;
        this.cartTotal = cartTotal;
        this.cartDeliveryFee = cartDeliveryFee;
        this.cartDiscountTotal = cartDiscountTotal;
        this.cartGrandTotal = cartGrandTotal;
        this.cartItemPriceTotal = cartItemPriceTotal;
        this.cartTotalCgstPercentage = cartTotalCgstPercentage;
        this.cartTotalSgstPercentage = cartTotalSgstPercentage;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }

    public String getCustomerTenantId() {
        return customerTenantId;
    }

    public void setCustomerTenantId(String customerTenantId) {
        this.customerTenantId = customerTenantId;
    }

    public List<Item> getCartMenuList() {
        return cartMenuList;
    }

    public void setCartMenuList(List<Item> cartMenuList) {
        this.cartMenuList = cartMenuList;
    }

    public Integer getIsOrderPlaced() {
        return isOrderPlaced;
    }

    public void setIsOrderPlaced(Integer isOrderPlaced) {
        this.isOrderPlaced = isOrderPlaced;
    }

    public String getCouponAppliedOnCart() {
        return couponAppliedOnCart;
    }

    public void setCouponAppliedOnCart(String couponAppliedOnCart) {
        this.couponAppliedOnCart = couponAppliedOnCart;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(Double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public Double getCartDeliveryFee() {
        return cartDeliveryFee;
    }

    public void setCartDeliveryFee(Double cartDeliveryFee) {
        this.cartDeliveryFee = cartDeliveryFee;
    }

    public Double getCartDiscountTotal() {
        return cartDiscountTotal;
    }

    public void setCartDiscountTotal(Double cartDiscountTotal) {
        this.cartDiscountTotal = cartDiscountTotal;
    }

    public Double getCartGrandTotal() {
        return cartGrandTotal;
    }

    public void setCartGrandTotal(Double cartGrandTotal) {
        this.cartGrandTotal = cartGrandTotal;
    }

    public Double getCartItemPriceTotal() {
        return cartItemPriceTotal;
    }

    public void setCartItemPriceTotal(Double cartItemPriceTotal) {
        this.cartItemPriceTotal = cartItemPriceTotal;
    }

    public Double getCartTotalCgstPercentage() {
        return cartTotalCgstPercentage;
    }

    public void setCartTotalCgstPercentage(Double cartTotalCgstPercentage) {
        this.cartTotalCgstPercentage = cartTotalCgstPercentage;
    }

    public Double getCartTotalSgstPercentage() {
        return cartTotalSgstPercentage;
    }

    public void setCartTotalSgstPercentage(Double cartTotalSgstPercentage) {
        this.cartTotalSgstPercentage = cartTotalSgstPercentage;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "restaurantTenantId='" + restaurantTenantId + '\'' +
                ", customerTenantId='" + customerTenantId + '\'' +
                ", cartMenuList=" + cartMenuList +
                ", isOrderPlaced=" + isOrderPlaced +
                ", couponAppliedOnCart='" + couponAppliedOnCart + '\'' +
                ", cartTotal=" + cartTotal +
                ", cartDeliveryFee=" + cartDeliveryFee +
                ", cartDiscountTotal=" + cartDiscountTotal +
                ", cartGrandTotal=" + cartGrandTotal +
                ", cartItemPriceTotal=" + cartItemPriceTotal +
                ", cartTotalCgstPercentage=" + cartTotalCgstPercentage +
                ", cartTotalSgstPercentage=" + cartTotalSgstPercentage +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
