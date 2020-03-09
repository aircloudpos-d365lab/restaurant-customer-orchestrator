package com.d365lab.eatery.restaurantcustomerorchestrator.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer_info")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class CustomerInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @NotNull
    @Size(max = 30)
    @Column(name = "customer_tenant_id")
    private String customerTenantId;

    @NotNull
    @Size(max = 12)
    @Column(name = "customer_primary_contact_number")
    private String customerPrimaryContactNo;

    @Size(max = 12)
    @Column(name = "customer_secondary_contact_number")
    private String customerSecondaryContactNo;

    @Size(max = 30)
    @Column(name = "customer_name")
    private String customerName;

    @Size(max = 20)
    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_address_type")
    private String customerAddressType;

    @Column(name = "customer_address")
    private String customerAddress;

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

    public CustomerInfo() {
    }

    public CustomerInfo(Integer customerId, @NotNull @Size(max = 30) String customerTenantId, @NotNull @Size(max = 12) String customerPrimaryContactNo, @NotNull @Size(max = 12) String customerSecondaryContactNo, @Size(max = 30) String customerName, @NotBlank @Size(max = 20) String customerEmail, String customerAddressType, String customerAddress, String restaurantTenantId) {
        this.customerId = customerId;
        this.customerTenantId = customerTenantId;
        this.customerPrimaryContactNo = customerPrimaryContactNo;
        this.customerSecondaryContactNo = customerSecondaryContactNo;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddressType = customerAddressType;
        this.customerAddress = customerAddress;
        this.restaurantTenantId = restaurantTenantId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerTenantId() {
        return customerTenantId;
    }

    public void setCustomerTenantId(String customerTenantId) {
        this.customerTenantId = customerTenantId;
    }

    public String getCustomerPrimaryContactNo() {
        return customerPrimaryContactNo;
    }

    public void setCustomerPrimaryContactNo(String customerPrimaryContactNo) {
        this.customerPrimaryContactNo = customerPrimaryContactNo;
    }

    public String getCustomerSecondaryContactNo() {
        return customerSecondaryContactNo;
    }

    public void setCustomerSecondaryContactNo(String customerSecondaryContactNo) {
        this.customerSecondaryContactNo = customerSecondaryContactNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddressType() {
        return customerAddressType;
    }

    public void setCustomerAddressType(String customerAddressType) {
        this.customerAddressType = customerAddressType;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
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

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }
}
