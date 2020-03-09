package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;

public class RestaurantOrderInputPayload implements Serializable {

    private String restaurantTenantId;
    private Integer cartId;
    private Double orderTotal;
    private Double orderDiscountTotal;
    private Double orderGrandTotal;
    private String orderChannel;
    private String orderPaymentMode;
    private String orderSpecialInstructions;
    private String orderAppliedCoupon;
    private String customerTenantId;
    private String orderDeliveryAddress;
    private Integer isOrderAcceptedByRestaurant;
    private Integer isOrderPreparedByRestaurant;
    private Integer isOrderPaymentConfirmed;
    private Integer isOrderDelivered;
    private String restaurantOrderMode;
    private Double orderTotalCgstPercentage;
    private Double orderTotalSgstPercentage;
    private Integer isOrderOutForDelivery;
    private Integer isOrderCancelledByRestaurant;
    private Integer isOrderCancelledByCustomer;
    private Integer isOrderStartedPreparingByRestaurant;
    private String cancellationReason;

    public RestaurantOrderInputPayload() {
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Double getOrderDiscountTotal() {
        return orderDiscountTotal;
    }

    public void setOrderDiscountTotal(Double orderDiscountTotal) {
        this.orderDiscountTotal = orderDiscountTotal;
    }

    public Double getOrderGrandTotal() {
        return orderGrandTotal;
    }

    public void setOrderGrandTotal(Double orderGrandTotal) {
        this.orderGrandTotal = orderGrandTotal;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }

    public String getOrderPaymentMode() {
        return orderPaymentMode;
    }

    public void setOrderPaymentMode(String orderPaymentMode) {
        this.orderPaymentMode = orderPaymentMode;
    }

    public String getOrderSpecialInstructions() {
        return orderSpecialInstructions;
    }

    public void setOrderSpecialInstructions(String orderSpecialInstructions) {
        this.orderSpecialInstructions = orderSpecialInstructions;
    }

    public String getOrderAppliedCoupon() {
        return orderAppliedCoupon;
    }

    public void setOrderAppliedCoupon(String orderAppliedCoupon) {
        this.orderAppliedCoupon = orderAppliedCoupon;
    }

    public String getCustomerTenantId() {
        return customerTenantId;
    }

    public void setCustomerTenantId(String customerTenantId) {
        this.customerTenantId = customerTenantId;
    }

    public String getOrderDeliveryAddress() {
        return orderDeliveryAddress.isEmpty() ? "SELF" : orderDeliveryAddress;
    }

    public void setOrderDeliveryAddress(String orderDeliveryAddress) {
        this.orderDeliveryAddress = orderDeliveryAddress;
    }

    public Integer getIsOrderAcceptedByRestaurant() {
        return isOrderAcceptedByRestaurant;
    }

    public void setIsOrderAcceptedByRestaurant(Integer isOrderAcceptedByRestaurant) {
        this.isOrderAcceptedByRestaurant = isOrderAcceptedByRestaurant;
    }

    public Integer getIsOrderPreparedByRestaurant() {
        return isOrderPreparedByRestaurant;
    }

    public void setIsOrderPreparedByRestaurant(Integer isOrderPreparedByRestaurant) {
        this.isOrderPreparedByRestaurant = isOrderPreparedByRestaurant;
    }

    public Integer getIsOrderPaymentConfirmed() {
        return isOrderPaymentConfirmed;
    }

    public void setIsOrderPaymentConfirmed(Integer isOrderPaymentConfirmed) {
        this.isOrderPaymentConfirmed = isOrderPaymentConfirmed;
    }

    public Integer getIsOrderDelivered() {
        return isOrderDelivered;
    }

    public void setIsOrderDelivered(Integer isOrderDelivered) {
        this.isOrderDelivered = isOrderDelivered;
    }

    public String getRestaurantOrderMode() {
        return restaurantOrderMode;
    }

    public void setRestaurantOrderMode(String restaurantOrderMode) {
        this.restaurantOrderMode = restaurantOrderMode;
    }

    public Double getOrderTotalCgstPercentage() {
        return orderTotalCgstPercentage;
    }

    public void setOrderTotalCgstPercentage(Double orderTotalCgstPercentage) {
        this.orderTotalCgstPercentage = orderTotalCgstPercentage;
    }

    public Double getOrderTotalSgstPercentage() {
        return orderTotalSgstPercentage;
    }

    public void setOrderTotalSgstPercentage(Double orderTotalSgstPercentage) {
        this.orderTotalSgstPercentage = orderTotalSgstPercentage;
    }

    public Integer getIsOrderOutForDelivery() {
        return isOrderOutForDelivery;
    }

    public void setIsOrderOutForDelivery(Integer isOrderOutForDelivery) {
        this.isOrderOutForDelivery = isOrderOutForDelivery;
    }

    public Integer getIsOrderCancelledByRestaurant() {
        return isOrderCancelledByRestaurant;
    }

    public void setIsOrderCancelledByRestaurant(Integer isOrderCancelledByRestaurant) {
        this.isOrderCancelledByRestaurant = isOrderCancelledByRestaurant;
    }

    public Integer getIsOrderCancelledByCustomer() {
        return isOrderCancelledByCustomer;
    }

    public void setIsOrderCancelledByCustomer(Integer isOrderCancelledByCustomer) {
        this.isOrderCancelledByCustomer = isOrderCancelledByCustomer;
    }

    public Integer getIsOrderStartedPreparingByRestaurant() {
        return isOrderStartedPreparingByRestaurant;
    }

    public void setIsOrderStartedPreparingByRestaurant(Integer isOrderStartedPreparingByRestaurant) {
        this.isOrderStartedPreparingByRestaurant = isOrderStartedPreparingByRestaurant;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }
}
