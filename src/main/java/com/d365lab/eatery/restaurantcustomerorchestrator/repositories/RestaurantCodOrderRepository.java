package com.d365lab.eatery.restaurantcustomerorchestrator.repositories;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantCodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface RestaurantCodOrderRepository extends JpaRepository<RestaurantCodOrder, Integer> {

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE restaurant_cod_order SET is_amount_collected = 1 WHERE restaurant_cod_order_id = :restaurantCodOrderId", nativeQuery = true)
//    void updateCashCollectedForCodOrder(Integer restaurantCodOrderId);

    @Query(value = "SELECT * FROM restaurant_cod_order WHERE restaurant_cod_order_id = :restaurantOrderId", nativeQuery = true)
    RestaurantCodOrder findIfCodOrderExists(Integer restaurantOrderId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_cod_order SET is_amount_collected = :newValue, amount_collected_through = :amountCollectedThrough, updated_at = :date  WHERE restaurant_cod_order_id = :restaurantOrderId", nativeQuery = true)
    void updateAmountCollectionForCodOrder(Integer restaurantOrderId, Integer newValue, String amountCollectedThrough, Date date);
}
