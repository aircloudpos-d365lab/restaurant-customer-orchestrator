package com.d365lab.eatery.restaurantcustomerorchestrator.services;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.CustomerOrchestratorException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerOrchestratorService {
    CustomerInfo addCustomerInfo(CustomerInfo customerInfoPayload) throws CustomerOrchestratorException;
    CustomerInfo getCustomerDetails(String customerTenantId);
    void updateCustomerInfo(CustomerInfo customerInfoPayload);
    void updateCustomerAddress(String customerTenantId, String customerContactNumber, String customerName, String customerAddressType, String customerAddress);
    List<CustomerInfo> getCustomersForRestaurant(String restaurantTenantId);
}
