package com.d365lab.eatery.restaurantcustomerorchestrator.repositories;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, String> {

    @Query(value = "SELECT * FROM customer_info WHERE customer_tenant_id = :customerTenantId", nativeQuery = true)
    CustomerInfo findCustomerInfoForRestaurant(String customerTenantId);

    @Query(value = "SELECT * FROM customer_info WHERE restaurant_tenant_id = :restaurantTenantId", nativeQuery = true)
    List<CustomerInfo> findCustomersForRestaurant(String restaurantTenantId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customer_info SET customer_tenant_id = :customerTenantId, customer_primary_contact_number = :customerPrimaryContactNumber, customer_secondary_contact_number = :customerSecondaryContactNumber, customer_name = :customerName, customer_email = :customerEmail, customer_address_type = :customerAddressType, customer_address = :customerAddress, updated_at = :updatedAt WHERE customer_id = :customerId", nativeQuery = true)
    void updateCustomerInfo(Integer customerId, String customerTenantId, String customerPrimaryContactNumber, String customerSecondaryContactNumber, String customerName, String customerEmail, String customerAddressType, String customerAddress, Date updatedAt);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customer_info SET customer_primary_contact_no = :customerPrimaryContactNumber, customer_secondary_contact_no = :customerSecondaryContactNumber, customer_name = :customerName, customer_address_type = :customerAddressType, customer_address = :customerAddress, updated_at = :updatedAt WHERE customer_tenant_id = :customerTenantId", nativeQuery = true)
    void updateCustomerAddress(String customerTenantId, String customerPrimaryContactNumber, String customerSecondaryContactNumber, String customerName, String customerAddressType, String customerAddress);
}
