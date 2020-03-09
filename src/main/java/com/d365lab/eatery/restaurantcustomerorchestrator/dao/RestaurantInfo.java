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

@Entity(name = "restaurant_info")
@Table(name = "restaurant_info")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class RestaurantInfo implements Serializable {

//    @EmbeddedId
//    private RestaurantInfoIdentity restaurantInfoIdentity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Integer restaurantId;

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

    @NotNull
    @Size(max = 100)
    @Column(name = "restaurant_email")
    private String restaurantEmail;

    @NotNull
    @Size(max = 12)
    @Column(name = "restaurant_contact_no")
    private String restaurantContactNo;

    @NotNull
    @Size(max = 15)
    @Column(name = "restaurant_primary_bank_account_number")
    private String restaurantPrimaryBankAccountNumber;

    @Column(name = "restaurant_address", columnDefinition="TEXT")
    private String restaurantAddress;

    @Size(max = 25)
    @Column(name = "restaurant_primary_bank_account_bank_name")
    private String restaurantPrimaryBankAccountBankName;

    @Size(max = 15)
    @Column(name = "restaurant_primary_bank_account_holder_name")
    private String restaurantPrimaryBankAccountHolderName;

    @Size(max = 15)
    @Column(name = "restaurant_primary_bank_account_ifsc")
    private String restaurantPrimaryBankAccountIfsc;

    @Size(max = 15)
    @Column(name = "restaurant_secondary_bank_account_number")
    private String restaurantSecondaryBankAccountNumber;

    @Size(max = 25)
    @Column(name = "restaurant_secondary_bank_account_bank_name")
    private String restaurantSecondaryBankAccountBankName;

    @Size(max = 15)
    @Column(name = "restaurant_secondary_bank_account_holder_name")
    private String restaurantSecondaryBankAccountHolderName;

    @Size(max = 15)
    @Column(name = "restaurant_secondary_bank_account_ifsc")
    private String restaurantSecondaryBankAccountIfsc;

    @Column(name = "restaurant_logo_url")
    private String restaurantLogo;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public RestaurantInfo() {
    }

    public RestaurantInfo(@NotNull @Size(max = 255) String restaurantBrandName, @NotNull @Size(max = 255) String restaurantOutletName, @NotNull @Size(max = 100) String restaurantEmail, @NotNull @Size(max = 12) String restaurantContactNo, @NotNull @Size(max = 15) String restaurantPrimaryBankAccountNumber, String restaurantAddress, @Size(max = 25) String restaurantPrimaryBankAccountBankName, @Size(max = 15) String restaurantPrimaryBankAccountHolderName, @Size(max = 15) String restaurantPrimaryBankAccountIfsc, @Size(max = 15) String restaurantSecondaryBankAccountNumber, @Size(max = 25) String restaurantSecondaryBankAccountBankName, @Size(max = 15) String restaurantSecondaryBankAccountHolderName, @Size(max = 15) String restaurantSecondaryBankAccountIfsc, String restaurantLogo) {
        this.restaurantBrandName = restaurantBrandName;
        this.restaurantOutletName = restaurantOutletName;
        this.restaurantEmail = restaurantEmail;
        this.restaurantContactNo = restaurantContactNo;
        this.restaurantPrimaryBankAccountNumber = restaurantPrimaryBankAccountNumber;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPrimaryBankAccountBankName = restaurantPrimaryBankAccountBankName;
        this.restaurantPrimaryBankAccountHolderName = restaurantPrimaryBankAccountHolderName;
        this.restaurantPrimaryBankAccountIfsc = restaurantPrimaryBankAccountIfsc;
        this.restaurantSecondaryBankAccountNumber = restaurantSecondaryBankAccountNumber;
        this.restaurantSecondaryBankAccountBankName = restaurantSecondaryBankAccountBankName;
        this.restaurantSecondaryBankAccountHolderName = restaurantSecondaryBankAccountHolderName;
        this.restaurantSecondaryBankAccountIfsc = restaurantSecondaryBankAccountIfsc;
        this.restaurantLogo = restaurantLogo;
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

    public String getRestaurantEmail() {
        return restaurantEmail;
    }

    public void setRestaurantEmail(String restaurantEmail) {
        this.restaurantEmail = restaurantEmail;
    }

    public String getRestaurantContactNo() {
        return restaurantContactNo;
    }

    public void setRestaurantContactNo(String restaurantContactNo) {
        this.restaurantContactNo = restaurantContactNo;
    }

    public String getRestaurantPrimaryBankAccountNumber() {
        return restaurantPrimaryBankAccountNumber;
    }

    public void setRestaurantPrimaryBankAccountNumber(String restaurantPrimaryBankAccountNumber) {
        this.restaurantPrimaryBankAccountNumber = restaurantPrimaryBankAccountNumber;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantPrimaryBankAccountBankName() {
        return restaurantPrimaryBankAccountBankName;
    }

    public void setRestaurantPrimaryBankAccountBankName(String restaurantPrimaryBankAccountBankName) {
        this.restaurantPrimaryBankAccountBankName = restaurantPrimaryBankAccountBankName;
    }

    public String getRestaurantPrimaryBankAccountHolderName() {
        return restaurantPrimaryBankAccountHolderName;
    }

    public void setRestaurantPrimaryBankAccountHolderName(String restaurantPrimaryBankAccountHolderName) {
        this.restaurantPrimaryBankAccountHolderName = restaurantPrimaryBankAccountHolderName;
    }

    public String getRestaurantPrimaryBankAccountIfsc() {
        return restaurantPrimaryBankAccountIfsc;
    }

    public void setRestaurantPrimaryBankAccountIfsc(String restaurantPrimaryBankAccountIfsc) {
        this.restaurantPrimaryBankAccountIfsc = restaurantPrimaryBankAccountIfsc;
    }

    public String getRestaurantSecondaryBankAccountNumber() {
        return restaurantSecondaryBankAccountNumber;
    }

    public void setRestaurantSecondaryBankAccountNumber(String restaurantSecondaryBankAccountNumber) {
        this.restaurantSecondaryBankAccountNumber = restaurantSecondaryBankAccountNumber;
    }

    public String getRestaurantSecondaryBankAccountBankName() {
        return restaurantSecondaryBankAccountBankName;
    }

    public void setRestaurantSecondaryBankAccountBankName(String restaurantSecondaryBankAccountBankName) {
        this.restaurantSecondaryBankAccountBankName = restaurantSecondaryBankAccountBankName;
    }

    public String getRestaurantSecondaryBankAccountHolderName() {
        return restaurantSecondaryBankAccountHolderName;
    }

    public void setRestaurantSecondaryBankAccountHolderName(String restaurantSecondaryBankAccountHolderName) {
        this.restaurantSecondaryBankAccountHolderName = restaurantSecondaryBankAccountHolderName;
    }

    public String getRestaurantSecondaryBankAccountIfsc() {
        return restaurantSecondaryBankAccountIfsc;
    }

    public void setRestaurantSecondaryBankAccountIfsc(String restaurantSecondaryBankAccountIfsc) {
        this.restaurantSecondaryBankAccountIfsc = restaurantSecondaryBankAccountIfsc;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantLogo() {
        return restaurantLogo;
    }

    public void setRestaurantLogo(String restaurantLogo) {
        this.restaurantLogo = restaurantLogo;
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

    public String getRestaurantOutletName() {
        return restaurantOutletName;
    }

    public void setRestaurantOutletName(String restaurantOutletName) {
        this.restaurantOutletName = restaurantOutletName;
    }
}
