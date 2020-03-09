package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;

public class CustomerAddress implements Serializable {

    private String customerTenantId;
    private String customerName;
    private String customerContactNumber;
    private String customerAddressType;
    private String customerAddress;

    public CustomerAddress() {
    }

    public CustomerAddress(String customerTenantId, String customerName, String customerContactNumber, String customerAddressType, String customerAddress) {
        this.customerTenantId = customerTenantId;
        this.customerName = customerName;
        this.customerContactNumber = customerContactNumber;
        this.customerAddressType = customerAddressType;
        this.customerAddress = customerAddress;
    }

    public String getCustomerTenantId() {
        return customerTenantId;
    }

    public void setCustomerTenantId(String customerTenantId) {
        this.customerTenantId = customerTenantId;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }
}
