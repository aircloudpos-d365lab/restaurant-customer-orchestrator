package com.d365lab.eatery.restaurantcustomerorchestrator.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "restaurant_menu_category")
@Table(name = "restaurant_menu_category")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class RestaurantMenuCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_menu_category_id")
    private Integer restaurantMenuCategoryId;

    @NotNull
    @Column(name = "restaurant_menu_category_description")
    private String restaurantMenuCategoryDescription;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public RestaurantMenuCategory() {
    }

    public RestaurantMenuCategory(Integer restaurantMenuCategoryId, @NotNull String restaurantMenuCategoryDescription, Date createdAt, Date updatedAt) {
        this.restaurantMenuCategoryId = restaurantMenuCategoryId;
        this.restaurantMenuCategoryDescription = restaurantMenuCategoryDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getRestaurantMenuCategoryId() {
        return restaurantMenuCategoryId;
    }

    public void setRestaurantMenuCategoryId(Integer restaurantMenuCategoryId) {
        this.restaurantMenuCategoryId = restaurantMenuCategoryId;
    }

    public String getRestaurantMenuCategoryDescription() {
        return restaurantMenuCategoryDescription;
    }

    public void setRestaurantMenuCategoryDescription(String restaurantMenuCategoryDescription) {
        this.restaurantMenuCategoryDescription = restaurantMenuCategoryDescription;
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
