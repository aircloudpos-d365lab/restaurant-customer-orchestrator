package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;
import java.util.List;

public class OrderInvoice implements Serializable {
    private Integer orderInvoiceId;
    private String restaurantBrandName;
    private String restaurantOutletName;
    private String restaurantGstNumber;
    private String restaurantFssaiLicenseNumber;
    private String customerMobileNumber;
    private List<Item> orderedItemList;
    private Double orderTotal;
    private Double orderDiscountTotal;
    private Double orderGrandTotal;
    private Double orderTotalCgst;
    private Double orderTotalSgst;
    private String orderedVia;
    private String orderCouponApplied;
    private String orderPaidBy;
    private String orderDeliveryAddress;

    public OrderInvoice() {
    }

    public OrderInvoice(Integer orderInvoiceId, String restaurantBrandName, String restaurantOutletName, String restaurantGstNumber, String restaurantFssaiLicenseNumber, String customerMobileNumber, List<Item> orderedItemList, Double orderTotal, Double orderDiscountTotal, Double orderGrandTotal, Double orderTotalCgst, Double orderTotalSgst, String orderedVia, String orderCouponApplied, String orderPaidBy, String orderDeliveryAddress) {
        this.orderInvoiceId = orderInvoiceId;
        this.restaurantBrandName = restaurantBrandName;
        this.restaurantOutletName = restaurantOutletName;
        this.restaurantGstNumber = restaurantGstNumber;
        this.restaurantFssaiLicenseNumber = restaurantFssaiLicenseNumber;
        this.customerMobileNumber = customerMobileNumber;
        this.orderedItemList = orderedItemList;
        this.orderTotal = orderTotal;
        this.orderDiscountTotal = orderDiscountTotal;
        this.orderGrandTotal = orderGrandTotal;
        this.orderTotalCgst = orderTotalCgst;
        this.orderTotalSgst = orderTotalSgst;
        this.orderedVia = orderedVia;
        this.orderCouponApplied = orderCouponApplied;
        this.orderPaidBy = orderPaidBy;
        this.orderDeliveryAddress = orderDeliveryAddress;
    }

    public Integer getOrderInvoiceId() {
        return orderInvoiceId;
    }

    public void setOrderInvoiceId(Integer orderInvoiceId) {
        this.orderInvoiceId = orderInvoiceId;
    }

    public String getRestaurantBrandName() {
        return restaurantBrandName;
    }

    public void setRestaurantBrandName(String restaurantBrandName) {
        this.restaurantBrandName = restaurantBrandName;
    }

    public String getRestaurantOutletName() {
        return restaurantOutletName;
    }

    public void setRestaurantOutletName(String restaurantOutletName) {
        this.restaurantOutletName = restaurantOutletName;
    }

    public String getRestaurantGstNumber() {
        return restaurantGstNumber;
    }

    public void setRestaurantGstNumber(String restaurantGstNumber) {
        this.restaurantGstNumber = restaurantGstNumber;
    }

    public String getRestaurantFssaiLicenseNumber() {
        return restaurantFssaiLicenseNumber;
    }

    public void setRestaurantFssaiLicenseNumber(String restaurantFssaiLicenseNumber) {
        this.restaurantFssaiLicenseNumber = restaurantFssaiLicenseNumber;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public List<Item> getOrderedItemList() {
        return orderedItemList;
    }

    public void setOrderedItemList(List<Item> orderedItemList) {
        this.orderedItemList = orderedItemList;
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

    public Double getOrderTotalCgst() {
        return orderTotalCgst;
    }

    public void setOrderTotalCgst(Double orderTotalCgst) {
        this.orderTotalCgst = orderTotalCgst;
    }

    public Double getOrderTotalSgst() {
        return orderTotalSgst;
    }

    public void setOrderTotalSgst(Double orderTotalSgst) {
        this.orderTotalSgst = orderTotalSgst;
    }

    public String getOrderedVia() {
        return orderedVia;
    }

    public void setOrderedVia(String orderedVia) {
        this.orderedVia = orderedVia;
    }

    public String getOrderCouponApplied() {
        return orderCouponApplied;
    }

    public void setOrderCouponApplied(String orderCouponApplied) {
        this.orderCouponApplied = orderCouponApplied;
    }

    public String getOrderPaidBy() {
        return orderPaidBy;
    }

    public void setOrderPaidBy(String orderPaidBy) {
        this.orderPaidBy = orderPaidBy;
    }

    public String getOrderDeliveryAddress() {
        return orderDeliveryAddress;
    }

    public void setOrderDeliveryAddress(String orderDeliveryAddress) {
        this.orderDeliveryAddress = orderDeliveryAddress;
    }
}
