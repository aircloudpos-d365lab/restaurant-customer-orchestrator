package com.d365lab.eatery.restaurantcustomerorchestrator.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity(name = "restaurant_order")
@Table(name = "restaurant_order")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class RestaurantOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_order_id")
    private Integer restaurantOrderId;

    @Size(max = 30)
    @Column(name = "restaurant_outlet_tenant_id")
    private String restaurantTenantId;

    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "order_total")
    private Double orderTotal;

    @Column(name = "order_discount_total")
    private Double orderDiscountTotal;

    @Column(name = "order_grand_total")
    private Double orderGrandTotal;

    @Column(name = "order_channel", columnDefinition="TEXT")
    private String orderChannel;

    @Column(name = "order_payment_mode", columnDefinition="TEXT")
    private String orderPaymentMode;

    @Column(name = "order_special_instructions", columnDefinition="TEXT")
    private String orderSpecialInstructions;

    @Column(name = "order_applied_coupon", columnDefinition="TEXT")
    private String orderAppliedCoupon;

    @Size(max = 30)
    @Column(name = "customer_tenant_id")
    private String customerTenantId;

    @Column(name = "order_invoice_id")
    private Integer orderInvoiceId;

    @Column(name = "order_delivery_address", columnDefinition="TEXT")
    private String orderDeliveryAddress;

    @Column(name = "is_order_accepted_by_restaurant")
    private Integer isOrderAcceptedByRestaurant;

    @Column(name = "is_order_food_ready_by_restaurant")
    private Integer isOrderPreparedByRestaurant;

    @Column(name = "is_order_payment_confirmed")
    private Integer isOrderPaymentConfirmed;

    @Column(name = "is_order_delivered")
    private Integer isOrderDelivered;

    @Column(name = "restaurant_order_mode")
    private String restaurantOrderMode;

    @Column(name = "order_total_cgst_percentage")
    private Double orderTotalCgstPercentage;

    @Column(name = "order_total_sgst_percentage")
    private Double orderTotalSgstPercentage;

    @Column(name = "is_order_out_for_delivery")
    private Integer isOrderOutForDelivery;

    @Column(name = "is_order_cancelled_by_restaurant")
    private Integer isOrderCancelledByRestaurant;

    @Column(name = "is_order_cancelled_by_customer")
    private Integer isOrderCancelledByCustomer;

    @Column(name = "order_cancelled_at")
    private Date orderCancelledAt;

    @Column(name="order_accepted_by_restaurant_at")
    private Date orderAcceptedByRestaurantAt;

    @Column(name="order_food_ready_by_restaurant_at")
    private Date orderFoodReadyByRestaurantAt;

    @Column(name="order_out_for_delivery_by_restaurant_at")
    private Date orderOutForDeliveryByRestaurantAt;

    @Column(name="order_delivered_at")
    private Date orderDeliveredAt;

    @Column(name = "is_order_started_preparing_by_restaurant")
    private Integer isOrderStartedPreparingByRestaurant;

    @Column(name="order_started_preparing_at")
    private Date orderStartedPreparingAt;

    @Column(name = "order_date", nullable = false)
    private Integer orderDate;

    @Column(name = "cancellation_reason")
    private String cancellationReason;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public RestaurantOrder() {
    }

    public RestaurantOrder(Integer restaurantOrderId, @Size(max = 30) String restaurantTenantId, Integer cartId, Double orderTotal, Double orderDiscountTotal, Double orderGrandTotal, String orderChannel, String orderPaymentMode, String orderSpecialInstructions, String orderAppliedCoupon, @Size(max = 30) String customerTenantId, Integer orderInvoiceId, String orderDeliveryAddress, Integer isOrderAcceptedByRestaurant, Integer isOrderPreparedByRestaurant, Integer isOrderPaymentConfirmed, Integer isOrderDelivered, String restaurantOrderMode, Double orderTotalCgstPercentage, Double orderTotalSgstPercentage, Integer isOrderOutForDelivery, Integer isOrderCancelledByRestaurant, Integer isOrderCancelledByCustomer, Date orderCancelledAt, Date orderAcceptedByRestaurantAt, Date orderFoodReadyByRestaurantAt, Date orderOutForDeliveryByRestaurantAt, Date orderDeliveredAt, Integer isOrderStartedPreparingByRestaurant, Date orderStartedPreparingAt, Integer orderDate, String cancellationReason, Date createdAt, Date updatedAt) {
        this.restaurantOrderId = restaurantOrderId;
        this.restaurantTenantId = restaurantTenantId;
        this.cartId = cartId;
        this.orderTotal = orderTotal;
        this.orderDiscountTotal = orderDiscountTotal;
        this.orderGrandTotal = orderGrandTotal;
        this.orderChannel = orderChannel;
        this.orderPaymentMode = orderPaymentMode;
        this.orderSpecialInstructions = orderSpecialInstructions;
        this.orderAppliedCoupon = orderAppliedCoupon;
        this.customerTenantId = customerTenantId;
        this.orderInvoiceId = orderInvoiceId;
        this.orderDeliveryAddress = orderDeliveryAddress;
        this.isOrderAcceptedByRestaurant = isOrderAcceptedByRestaurant;
        this.isOrderPreparedByRestaurant = isOrderPreparedByRestaurant;
        this.isOrderPaymentConfirmed = isOrderPaymentConfirmed;
        this.isOrderDelivered = isOrderDelivered;
        this.restaurantOrderMode = restaurantOrderMode;
        this.orderTotalCgstPercentage = orderTotalCgstPercentage;
        this.orderTotalSgstPercentage = orderTotalSgstPercentage;
        this.isOrderOutForDelivery = isOrderOutForDelivery;
        this.isOrderCancelledByRestaurant = isOrderCancelledByRestaurant;
        this.isOrderCancelledByCustomer = isOrderCancelledByCustomer;
        this.orderCancelledAt = orderCancelledAt;
        this.orderAcceptedByRestaurantAt = orderAcceptedByRestaurantAt;
        this.orderFoodReadyByRestaurantAt = orderFoodReadyByRestaurantAt;
        this.orderOutForDeliveryByRestaurantAt = orderOutForDeliveryByRestaurantAt;
        this.orderDeliveredAt = orderDeliveredAt;
        this.isOrderStartedPreparingByRestaurant = isOrderStartedPreparingByRestaurant;
        this.orderStartedPreparingAt = orderStartedPreparingAt;
        this.orderDate = orderDate;
        this.cancellationReason = cancellationReason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getRestaurantOrderId() {
        return restaurantOrderId;
    }

    public void setRestaurantOrderId(Integer restaurantOrderId) {
        this.restaurantOrderId = restaurantOrderId;
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

    public Integer getOrderInvoiceId() {
        return orderInvoiceId;
    }

    public void setOrderInvoiceId(Integer orderInvoiceId) {
        this.orderInvoiceId = orderInvoiceId;
    }

    public String getOrderDeliveryAddress() {
        return orderDeliveryAddress;
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

    public Date getOrderAcceptedByRestaurantAt() {
        return orderAcceptedByRestaurantAt;
    }

    public void setOrderAcceptedByRestaurantAt(Date orderAcceptedByRestaurantAt) {
        this.orderAcceptedByRestaurantAt = orderAcceptedByRestaurantAt;
    }

    public Date getOrderFoodReadyByRestaurantAt() {
        return orderFoodReadyByRestaurantAt;
    }

    public void setOrderFoodReadyByRestaurantAt(Date orderFoodReadyByRestaurantAt) {
        this.orderFoodReadyByRestaurantAt = orderFoodReadyByRestaurantAt;
    }

    public Date getOrderOutForDeliveryByRestaurantAt() {
        return orderOutForDeliveryByRestaurantAt;
    }

    public void setOrderOutForDeliveryByRestaurantAt(Date orderOutForDeliveryByRestaurantAt) {
        this.orderOutForDeliveryByRestaurantAt = orderOutForDeliveryByRestaurantAt;
    }

    public Date getOrderDeliveredAt() {
        return orderDeliveredAt;
    }

    public void setOrderDeliveredAt(Date orderDeliveredAt) {
        this.orderDeliveredAt = orderDeliveredAt;
    }

    public Integer getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Integer orderDate) {
        this.orderDate = orderDate;
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

    public Date getOrderCancelledAt() {
        return orderCancelledAt;
    }

    public void setOrderCancelledAt(Date orderCancelledAt) {
        this.orderCancelledAt = orderCancelledAt;
    }

    public Integer getIsOrderStartedPreparingByRestaurant() {
        return isOrderStartedPreparingByRestaurant;
    }

    public void setIsOrderStartedPreparingByRestaurant(Integer isOrderStartedPreparingByRestaurant) {
        this.isOrderStartedPreparingByRestaurant = isOrderStartedPreparingByRestaurant;
    }

    public Date getOrderStartedPreparingAt() {
        return orderStartedPreparingAt;
    }

    public void setOrderStartedPreparingAt(Date orderStartedPreparingAt) {
        this.orderStartedPreparingAt = orderStartedPreparingAt;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }
}
