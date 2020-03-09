package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantPaymentOptions;

import java.io.Serializable;
import java.util.List;

public class RestaurantDetails implements Serializable {

    private String restaurantMasterTenantId;
    private String restaurantOutletTenantId;
    private String restaurantBrandName;
    private String restaurantOutletName;
    private String restaurantGstNumber;
    private String restaurantFssaiLicenseNumber;
    private String restaurantEmail;
    private String restaurantContactNo;
    private String restaurantAddress;
    private String restaurantPrimaryBankAccountNumber;
    private String restaurantPrimaryBankAccountBankName;
    private String restaurantPrimaryBankAccountHolderName;
    private String restaurantPrimaryBankAccountIfsc;
    private String restaurantSecondaryBankAccountNumber;
    private String restaurantSecondaryBankAccountBankName;
    private String restaurantSecondaryBankAccountHolderName;
    private String restaurantSecondaryBankAccountIfsc;
    private String restaurantLogo;
    private List<RestaurantMenuWithCustomization> menuList;
    private List<RestaurantPaymentOptions> restaurantPaymentOptionsList;

    public RestaurantDetails() {
    }

    public RestaurantDetails(String restaurantMasterTenantId, String restaurantOutletTenantId, String restaurantBrandName, String restaurantOutletName, String restaurantGstNumber, String restaurantFssaiLicenseNumber, String restaurantEmail, String restaurantContactNo, String restaurantAddress, String restaurantPrimaryBankAccountNumber, String restaurantPrimaryBankAccountBankName, String restaurantPrimaryBankAccountHolderName, String restaurantPrimaryBankAccountIfsc, String restaurantSecondaryBankAccountNumber, String restaurantSecondaryBankAccountBankName, String restaurantSecondaryBankAccountHolderName, String restaurantSecondaryBankAccountIfsc, String restaurantLogo, List<RestaurantMenuWithCustomization> menuList, List<RestaurantPaymentOptions> restaurantPaymentOptionsList) {
        this.restaurantMasterTenantId = restaurantMasterTenantId;
        this.restaurantOutletTenantId = restaurantOutletTenantId;
        this.restaurantBrandName = restaurantBrandName;
        this.restaurantOutletName = restaurantOutletName;
        this.restaurantGstNumber = restaurantGstNumber;
        this.restaurantFssaiLicenseNumber = restaurantFssaiLicenseNumber;
        this.restaurantEmail = restaurantEmail;
        this.restaurantContactNo = restaurantContactNo;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPrimaryBankAccountNumber = restaurantPrimaryBankAccountNumber;
        this.restaurantPrimaryBankAccountBankName = restaurantPrimaryBankAccountBankName;
        this.restaurantPrimaryBankAccountHolderName = restaurantPrimaryBankAccountHolderName;
        this.restaurantPrimaryBankAccountIfsc = restaurantPrimaryBankAccountIfsc;
        this.restaurantSecondaryBankAccountNumber = restaurantSecondaryBankAccountNumber;
        this.restaurantSecondaryBankAccountBankName = restaurantSecondaryBankAccountBankName;
        this.restaurantSecondaryBankAccountHolderName = restaurantSecondaryBankAccountHolderName;
        this.restaurantSecondaryBankAccountIfsc = restaurantSecondaryBankAccountIfsc;
        this.restaurantLogo = restaurantLogo;
        this.menuList = menuList;
        this.restaurantPaymentOptionsList = restaurantPaymentOptionsList;
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

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantPrimaryBankAccountNumber() {
        return restaurantPrimaryBankAccountNumber;
    }

    public void setRestaurantPrimaryBankAccountNumber(String restaurantPrimaryBankAccountNumber) {
        this.restaurantPrimaryBankAccountNumber = restaurantPrimaryBankAccountNumber;
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

    public String getRestaurantLogo() {
        return restaurantLogo;
    }

    public void setRestaurantLogo(String restaurantLogo) {
        this.restaurantLogo = restaurantLogo;
    }

    public List<RestaurantMenuWithCustomization> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<RestaurantMenuWithCustomization> menuList) {
        this.menuList = menuList;
    }

    public List<RestaurantPaymentOptions> getRestaurantPaymentOptionsList() {
        return restaurantPaymentOptionsList;
    }

    public void setRestaurantPaymentOptionsList(List<RestaurantPaymentOptions> restaurantPaymentOptionsList) {
        this.restaurantPaymentOptionsList = restaurantPaymentOptionsList;
    }
}
