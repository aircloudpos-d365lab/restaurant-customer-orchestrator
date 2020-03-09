package com.d365lab.eatery.restaurantcustomerorchestrator.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "restaurant_cod_order")
@Table(name = "restaurant_cod_order")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class RestaurantCodOrder implements Serializable {

    @Id
    @Column(name = "restaurant_cod_order_id")
    private Integer restaurantOrderId;

    @Column(name = "is_amount_collected")
    private Integer isAmountCollected;

    @Column(name = "restaurant_cod_order_grand_total")
    private Double restaurantCodOrderGrandTotal;

    @Column(name = "amount_collected_through")
    private String amountCollectedThrough;

    @Column(name = "restaurant_tenant_id")
    private String restaurantTenantId;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public RestaurantCodOrder() {
    }

    public RestaurantCodOrder(Integer restaurantOrderId, Integer isAmountCollected, Double restaurantCodOrderGrandTotal, String restaurantTenantId) {
        this.restaurantOrderId = restaurantOrderId;
        this.isAmountCollected = isAmountCollected;
        this.restaurantCodOrderGrandTotal = restaurantCodOrderGrandTotal;
        this.restaurantTenantId = restaurantTenantId;
    }

    public RestaurantCodOrder(Integer restaurantOrderId, Integer isAmountCollected, Double restaurantCodOrderGrandTotal, String amountCollectedThrough, String restaurantTenantId) {
        this.restaurantOrderId = restaurantOrderId;
        this.isAmountCollected = isAmountCollected;
        this.restaurantCodOrderGrandTotal = restaurantCodOrderGrandTotal;
        this.amountCollectedThrough = amountCollectedThrough;
        this.restaurantTenantId = restaurantTenantId;
    }

    public RestaurantCodOrder(Integer restaurantOrderId, Integer isAmountCollected, Double restaurantCodOrderGrandTotal, String amountCollectedThrough, String restaurantTenantId, Date createdAt, Date updatedAt) {
        this.restaurantOrderId = restaurantOrderId;
        this.isAmountCollected = isAmountCollected;
        this.restaurantCodOrderGrandTotal = restaurantCodOrderGrandTotal;
        this.amountCollectedThrough = amountCollectedThrough;
        this.restaurantTenantId = restaurantTenantId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getRestaurantOrderId() {
        return restaurantOrderId;
    }

    public void setRestaurantOrderId(Integer restaurantOrderId) {
        this.restaurantOrderId = restaurantOrderId;
    }

    public Integer getIsAmountCollected() {
        return isAmountCollected;
    }

    public void setIsAmountCollected(Integer isAmountCollected) {
        this.isAmountCollected = isAmountCollected;
    }

    public String getAmountCollectedThrough() {
        return amountCollectedThrough;
    }

    public void setAmountCollectedThrough(String amountCollectedThrough) {
        this.amountCollectedThrough = amountCollectedThrough;
    }

    public Double getRestaurantCodOrderGrandTotal() {
        return restaurantCodOrderGrandTotal;
    }

    public void setRestaurantCodOrderGrandTotal(Double restaurantCodOrderGrandTotal) {
        this.restaurantCodOrderGrandTotal = restaurantCodOrderGrandTotal;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
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
}
