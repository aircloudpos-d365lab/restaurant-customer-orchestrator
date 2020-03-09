package com.d365lab.eatery.restaurantcustomerorchestrator.dao;

import com.d365lab.eatery.restaurantcustomerorchestrator.model.enums.RestaurantPaymentMode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "restaurant_payment_options")
@Table(name = "restaurant_payment_options")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class RestaurantPaymentOptions implements Serializable {

//    @EmbeddedId
//    private RestaurantPaymentOptionsIdentity restaurantPaymentOptionsIdentity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_payment_option_id")
    private Integer restaurantPaymentOptionId;

    @NotNull
    @Size(max = 30)
    @Column(name = "restaurant_tenant_id")
    private String restaurantTenantId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "restaurant_payment_mode", length = 15)
    private RestaurantPaymentMode restaurantPaymentMode;

    @Column(name = "restaurant_qr")
    private String restaurantQr;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public RestaurantPaymentOptions() {
    }

    public RestaurantPaymentOptions(Integer restaurantPaymentOptionId, @NotNull @Size(max = 30) String restaurantTenantId, @NotNull RestaurantPaymentMode restaurantPaymentMode, String restaurantQr) {
        this.restaurantPaymentOptionId = restaurantPaymentOptionId;
        this.restaurantTenantId = restaurantTenantId;
        this.restaurantPaymentMode = restaurantPaymentMode;
        this.restaurantQr = restaurantQr;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }

    public RestaurantPaymentMode getRestaurantPaymentMode() {
        return restaurantPaymentMode;
    }

    public void setRestaurantPaymentMode(RestaurantPaymentMode restaurantPaymentMode) {
        this.restaurantPaymentMode = restaurantPaymentMode;
    }

    public Integer getRestaurantPaymentOptionId() {
        return restaurantPaymentOptionId;
    }

    public void setRestaurantPaymentOptionId(Integer restaurantPaymentOptionId) {
        this.restaurantPaymentOptionId = restaurantPaymentOptionId;
    }

    public String getRestaurantQr() {
        return restaurantQr;
    }

    public void setRestaurantQr(String restaurantQr) {
        this.restaurantQr = restaurantQr;
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
