package com.d365lab.eatery.restaurantcustomerorchestrator.services.impl;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo;
import com.d365lab.eatery.restaurantcustomerorchestrator.repositories.CustomerInfoRepository;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.CustomerOrchestratorService;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.CustomerOrchestratorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerOrchestratorServiceImpl implements CustomerOrchestratorService {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @Override
    public CustomerInfo addCustomerInfo(CustomerInfo customerInfoPayload) throws CustomerOrchestratorException {
            CustomerInfo customerInfo = customerInfoRepository.findCustomerInfoForRestaurant(customerInfoPayload.getCustomerTenantId());
            if (customerInfo == null) {
                return customerInfoRepository.save(customerInfoPayload);
            } else {
                throw new CustomerOrchestratorException("Customer Info is already present for customer with tenant-id:" + customerInfoPayload.getCustomerTenantId());
            }
    }

    @Override
    public CustomerInfo getCustomerDetails(String customerTenantId) {
        CustomerInfo customerInfo = customerInfoRepository.findCustomerInfoForRestaurant(customerTenantId);
        return customerInfo;
    }

    @Override
    public void updateCustomerInfo(CustomerInfo customerInfoPayload) {
        CustomerInfo customerInfo = customerInfoRepository.findCustomerInfoForRestaurant(customerInfoPayload.getCustomerTenantId());
        customerInfoRepository.updateCustomerInfo(customerInfo.getCustomerId(),
                customerInfoPayload.getCustomerTenantId(),
                customerInfoPayload.getCustomerPrimaryContactNo(),
                customerInfoPayload.getCustomerSecondaryContactNo(),
                customerInfoPayload.getCustomerName(),
                customerInfoPayload.getCustomerEmail(),
                customerInfoPayload.getCustomerAddressType(),
                customerInfoPayload.getCustomerAddress(),
                new Date());

    }

    @Override
    public void updateCustomerAddress(String customerTenantId, String customerContactNumber, String customerName, String customerAddressType, String customerAddress) {
        customerInfoRepository.updateCustomerAddress(customerTenantId, customerContactNumber, customerContactNumber, customerName, customerAddressType, customerAddress);
    }

    @Override
    public List<CustomerInfo> getCustomersForRestaurant(String restaurantTenantId) {
        List<CustomerInfo> customerInfoList = customerInfoRepository.findCustomersForRestaurant(restaurantTenantId);
        return customerInfoList;
    }

//    @Override
//    public void updateCustomerAddress(CustomerAddress customerAddressPayload) {
//        List<CustomerAddress> customerAddress = customerAddressRepository.findAddressesOfCustomerById(customerAddressPayload.getCustomerTenantId());
//    }
}
