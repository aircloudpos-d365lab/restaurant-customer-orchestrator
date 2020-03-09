package com.d365lab.eatery.restaurantcustomerorchestrator.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity(name = "restaurant_menu_customization")
@Table(name = "restaurant_menu_customization")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class RestaurantMenuCustomization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_menu_customization_id")
    private Integer restaurantMenuCustomizationId;

    @Size(max = 30)
    @Column(name = "restaurant_tenant_id")
    private String restaurantTenantId;

    @Column(name = "restaurant_menu_id")
    private Integer restaurantMenuId;

    @Column(name = "restaurant_menu_customization_description", columnDefinition="TEXT")
    private String restaurantMenuCustomizationDescription;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public RestaurantMenuCustomization() {
    }

    public RestaurantMenuCustomization(Integer restaurantMenuCustomizationId, @Size(max = 30) String restaurantTenantId, Integer restaurantMenuId, String restaurantMenuCustomizationDescription, Date createdAt, Date updatedAt) {
        this.restaurantMenuCustomizationId = restaurantMenuCustomizationId;
        this.restaurantTenantId = restaurantTenantId;
        this.restaurantMenuId = restaurantMenuId;
        this.restaurantMenuCustomizationDescription = restaurantMenuCustomizationDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public RestaurantMenuCustomization(@Size(max = 30) String restaurantTenantId, Integer restaurantMenuId, String restaurantMenuCustomizationDescription) {
        this.restaurantTenantId = restaurantTenantId;
        this.restaurantMenuId = restaurantMenuId;
        this.restaurantMenuCustomizationDescription = restaurantMenuCustomizationDescription;
    }

    public Integer getRestaurantMenuCustomizationId() {
        return restaurantMenuCustomizationId;
    }

    public void setRestaurantMenuCustomizationId(Integer restaurantMenuCustomizationId) {
        this.restaurantMenuCustomizationId = restaurantMenuCustomizationId;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }

    public Integer getRestaurantMenuId() {
        return restaurantMenuId;
    }

    public void setRestaurantMenuId(Integer restaurantMenuId) {
        this.restaurantMenuId = restaurantMenuId;
    }

    public String getRestaurantMenuCustomizationDescription() {
        return restaurantMenuCustomizationDescription;
    }

    public void setRestaurantMenuCustomizationDescription(String restaurantMenuCustomizationDescription) {
        this.restaurantMenuCustomizationDescription = restaurantMenuCustomizationDescription;
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
