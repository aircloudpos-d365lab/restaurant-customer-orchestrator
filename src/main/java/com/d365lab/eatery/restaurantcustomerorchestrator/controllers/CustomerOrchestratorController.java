package com.d365lab.eatery.restaurantcustomerorchestrator.controllers;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.CustomerAddress;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantCustomerMap;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderDetails;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.CustomerOrchestratorService;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrderService;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.CustomerOrchestratorException;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.RestaurantCustomerOrchestratorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerOrchestratorController {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerOrchestratorController.class);

    @Autowired
    private CustomerOrchestratorService customerOrchestratorService;

    @Autowired
    private RestaurantOrderService restaurantOrderService;

    // Create a new Customer-Info
    @PostMapping(value = "/customer-info/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerInfo> createCustomerInfoForARestaurant(@RequestBody CustomerInfo customerInfoPayload) {
        CustomerInfo customerInfo = null;
        try {
            customerInfo = customerOrchestratorService.addCustomerInfo(customerInfoPayload);
        } catch (CustomerOrchestratorException e) {
            LOGGER.error("Exception:{} occurred while creating customer-info for restaurant:{}", e.getMessage(), customerInfoPayload.getCustomerTenantId());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (customerInfo == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CustomerInfo>(customerInfo, HttpStatus.OK);
    }


    // Get a Single Customer-Details
    @RequestMapping(value = "/customer-details-for-mobile/", method = RequestMethod.GET)
    public ResponseEntity<CustomerInfo> getCustomerDetails(@RequestParam("customer_tenant_id") String customerTenantId) {
        CustomerInfo customerInfo = customerOrchestratorService.getCustomerDetails(customerTenantId);
        if (customerInfo == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<CustomerInfo>(customerInfo, HttpStatus.OK);
    }

    // Get Customer-List for a Restaurant
    @RequestMapping(value = "/customer-list-for-restaurant", method = RequestMethod.GET)
    public ResponseEntity<RestaurantCustomerMap> getCustomerListForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        List<CustomerInfo> customerInfoList = customerOrchestratorService.getCustomersForRestaurant(restaurantTenantId);
        if (customerInfoList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        RestaurantCustomerMap restaurantCustomerMap = new RestaurantCustomerMap(restaurantTenantId, customerInfoList);
        return new ResponseEntity<RestaurantCustomerMap>(restaurantCustomerMap, HttpStatus.OK);
    }


    // Update a Customer-Info
    @RequestMapping(value = "/customer-info/update", method = RequestMethod.POST)
    public ResponseEntity<String> updateCustomerInfo(@RequestBody CustomerInfo customerInfoPayload) throws CustomerOrchestratorException {
        customerOrchestratorService.updateCustomerInfo(customerInfoPayload);
        return new ResponseEntity<String>("Customer-Info is Updated Successfully!", HttpStatus.OK);
    }

    // Update a Customer-Address
    @RequestMapping(value = "/customer-address/update", method = RequestMethod.POST)
    public ResponseEntity<String> updateCustomerAddress(@RequestBody CustomerAddress customerAddressPayload) throws CustomerOrchestratorException {
        customerOrchestratorService.updateCustomerAddress(customerAddressPayload.getCustomerTenantId(),
                customerAddressPayload.getCustomerName(),
                customerAddressPayload.getCustomerContactNumber(),
                customerAddressPayload.getCustomerAddressType(),
                customerAddressPayload.getCustomerAddress());
        return new ResponseEntity<String>("Customer-Address is Updated Successfully!", HttpStatus.OK);
    }

    // Get All Past-Orders of a Customer
    @RequestMapping(value = "/old-order-history-of-customer", method = RequestMethod.GET)
    public ResponseEntity<RestaurantOrderDetails> getPastOrderListForACustomer(@RequestParam("customer_tenant_id") String customerTenantId) {
        try {
            if (customerTenantId == null || customerTenantId.isEmpty()) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else {
                RestaurantOrderDetails pastOrderListForCustomer = restaurantOrderService.getAllPastOrdersForACustomer(customerTenantId);
                if ( pastOrderListForCustomer == null || pastOrderListForCustomer.getRestaurantOrderOutputPayloadList().isEmpty()) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
                else {
                    return new ResponseEntity<RestaurantOrderDetails>(pastOrderListForCustomer, HttpStatus.OK);
                }
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception: {} occurred while getting past order-details of customer: {}", e.getMessage(), customerTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Get All Active-Orders of a Customer
    @RequestMapping(value = "/active-order-history-of-customer", method = RequestMethod.GET)
    public ResponseEntity<RestaurantOrderDetails> getActiveOrderListForACustomer(@RequestParam("customer_tenant_id") String customerTenantId) {
        try {
            if (customerTenantId == null || customerTenantId.isEmpty()) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else {
                RestaurantOrderDetails pastOrderListForCustomer = restaurantOrderService.getAllActiveOrdersForACustomer(customerTenantId);
                if ( pastOrderListForCustomer == null || pastOrderListForCustomer.getRestaurantOrderOutputPayloadList().isEmpty()) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
                else {
                    return new ResponseEntity<RestaurantOrderDetails>(pastOrderListForCustomer, HttpStatus.OK);
                }
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception: {} occurred while getting past order-details of customer: {}", e.getMessage(), customerTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
