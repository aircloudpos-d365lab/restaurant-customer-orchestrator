package com.d365lab.eatery.restaurantcustomerorchestrator.repositories;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantPaymentOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantPaymentOptionsRepository extends JpaRepository<RestaurantPaymentOptions, Integer> {

    @Query(value = "SELECT r FROM restaurant_payment_options r WHERE restaurant_tenant_id = :restaurantTenantId")
    List<RestaurantPaymentOptions> findRestaurantPaymentOptionsForRestaurant(@Param("restaurantTenantId") String restaurantTenantId);
}
