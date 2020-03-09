package com.d365lab.eatery.restaurantcustomerorchestrator.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "restaurant_login")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class RestaurantLogin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_login_id")
    private Integer restaurantLoginId;

    @NotNull
    @Size(max = 255)
    @Column(name = "restaurant_username")
    private String restaurantUsername;

    @NotNull
    @Size(max = 255)
    @Column(name = "restaurant_encrypted_password")
    private String restaurantEncryptedPassword;

    @NotNull
    @Size(max = 255)
    @Column(name = "restaurant_salt")
    private String restaurantSalt;

    @NotNull
    @Size(max = 30)
    @Column(name = "restaurant_master_tenant_id")
    private String restaurantMasterTenantId;

    @NotNull
    @Size(max = 30)
    @Column(name = "restaurant_outlet_tenant_id")
    private String restaurantOutletTenantId;

    @NotNull
    @Size(max = 255)
    @Column(name = "restaurant_brand_name")
    private String restaurantBrandName;

    @NotNull
    @Size(max = 255)
    @Column(name = "restaurant_outlet_name")
    private String restaurantOutletName;

    @Column(name = "is_logged_in")
    private Integer isLoggedIn;

    @Column(name = "last_logged_in_at")
    private Date lastLoggedInAt;


    public RestaurantLogin() {
    }

    public RestaurantLogin(Integer restaurantLoginId, @NotNull @Size(max = 255) String restaurantUsername, @NotNull @Size(max = 255) String restaurantEncryptedPassword, @NotNull @Size(max = 255) String restaurantSalt, @NotNull @Size(max = 30) String restaurantMasterTenantId, @NotNull @Size(max = 30) String restaurantOutletTenantId, @NotNull @Size(max = 255) String restaurantBrandName, @NotNull @Size(max = 255) String restaurantOutletName, Integer isLoggedIn, Date lastLoggedInAt) {
        this.restaurantLoginId = restaurantLoginId;
        this.restaurantUsername = restaurantUsername;
        this.restaurantEncryptedPassword = restaurantEncryptedPassword;
        this.restaurantSalt = restaurantSalt;
        this.restaurantMasterTenantId = restaurantMasterTenantId;
        this.restaurantOutletTenantId = restaurantOutletTenantId;
        this.restaurantBrandName = restaurantBrandName;
        this.restaurantOutletName = restaurantOutletName;
        this.isLoggedIn = isLoggedIn;
        this.lastLoggedInAt = lastLoggedInAt;
    }

    public RestaurantLogin(@NotNull @Size(max = 255) String restaurantUsername, @NotNull @Size(max = 255) String restaurantEncryptedPassword, @NotNull @Size(max = 255) String restaurantSalt, @NotNull @Size(max = 30) String restaurantMasterTenantId, @NotNull @Size(max = 30) String restaurantOutletTenantId, @NotNull @Size(max = 255) String restaurantBrandName, @NotNull @Size(max = 255) String restaurantOutletName, Integer isLoggedIn, Date lastLoggedInAt) {
        this.restaurantUsername = restaurantUsername;
        this.restaurantEncryptedPassword = restaurantEncryptedPassword;
        this.restaurantSalt = restaurantSalt;
        this.restaurantMasterTenantId = restaurantMasterTenantId;
        this.restaurantOutletTenantId = restaurantOutletTenantId;
        this.restaurantBrandName = restaurantBrandName;
        this.restaurantOutletName = restaurantOutletName;
        this.isLoggedIn = isLoggedIn;
        this.lastLoggedInAt = lastLoggedInAt;
    }

    public Integer getRestaurantLoginId() {
        return restaurantLoginId;
    }

    public void setRestaurantLoginId(Integer restaurantLoginId) {
        this.restaurantLoginId = restaurantLoginId;
    }

    public String getRestaurantUsername() {
        return restaurantUsername;
    }

    public void setRestaurantUsername(String restaurantUsername) {
        this.restaurantUsername = restaurantUsername;
    }

    public String getRestaurantEncryptedPassword() {
        return restaurantEncryptedPassword;
    }

    public void setRestaurantEncryptedPassword(String restaurantEncryptedPassword) {
        this.restaurantEncryptedPassword = restaurantEncryptedPassword;
    }

    public String getRestaurantSalt() {
        return restaurantSalt;
    }

    public void setRestaurantSalt(String restaurantSalt) {
        this.restaurantSalt = restaurantSalt;
    }

    public String getRestaurantMasterTenantId() {
        return restaurantMasterTenantId;
    }

    public void setRestaurantMasterTenantId(String restaurantMasterTenantId) {
        this.restaurantMasterTenantId = restaurantMasterTenantId;
    }

    public String getRestaurantOutletTenantId() {
        return restaurantOutletTenantId;
    }

    public void setRestaurantOutletTenantId(String restaurantOutletTenantId) {
        this.restaurantOutletTenantId = restaurantOutletTenantId;
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

    @Override
    public String toString() {
        return "RestaurantLogin{" +
                "restaurantLoginId=" + restaurantLoginId +
                ", restaurantUsername='" + restaurantUsername + '\'' +
                ", restaurantEncryptedPassword='" + restaurantEncryptedPassword + '\'' +
                ", restaurantSalt='" + restaurantSalt + '\'' +
                ", restaurantMasterTenantId='" + restaurantMasterTenantId + '\'' +
                ", restaurantOutletTenantId='" + restaurantOutletTenantId + '\'' +
                ", restaurantBrandName='" + restaurantBrandName + '\'' +
                ", restaurantOutletName='" + restaurantOutletName + '\'' +
                ", isLoggedIn=" + isLoggedIn +
                ", lastLoggedInAt=" + lastLoggedInAt +
                '}';
    }
}
