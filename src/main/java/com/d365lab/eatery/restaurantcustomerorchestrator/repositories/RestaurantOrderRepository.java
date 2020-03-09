package com.d365lab.eatery.restaurantcustomerorchestrator.repositories;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantOrder;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderOutputPayload;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface RestaurantOrderRepository extends JpaRepository<RestaurantOrder, Long> {

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId ORDER BY restaurant_order_id DESC", nativeQuery = true)
    Page<RestaurantOrder> findAllOrdersForRestaurantWithPagination(@Param("restaurantTenantId") String restaurantTenantId, Pageable pageable);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    RestaurantOrder findRestaurantOrderDetails(@Param("restaurantOrderId") Integer restaurantOrderId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_order SET order_invoice_id = :restaurantOrderId WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    void updateInvoiceNumberForOrder(Integer restaurantOrderId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_order SET is_order_food_ready_by_restaurant = :newValue, order_food_ready_by_restaurant_at = :date WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    void updateOrderPreparedFlagForOrder(Integer restaurantOrderId, Integer newValue, Date date);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_order SET is_order_payment_confirmed = :newValue WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    void updatePaymentConfirmedFlagForOrder(Integer restaurantOrderId, Integer newValue);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_order SET is_order_accepted_by_restaurant = :newValue, order_accepted_by_restaurant_at = :date, is_order_started_preparing_by_restaurant = :newValue, order_started_preparing_at = :date WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    void updateOrderAcceptedFlagForOrder(Integer restaurantOrderId, Integer newValue, Date date);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_order SET is_order_delivered = :newValue, order_delivered_at = :date WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    void updateDeliveredFlagForOrder(Integer restaurantOrderId, Integer newValue, Date date);


    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_order SET is_order_out_for_delivery = :newValue, order_out_for_delivery_by_restaurant_at = :date WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    void updateOutForDeliveryFlagForOrder(Integer restaurantOrderId, Integer newValue, Date date);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_order SET is_order_cancelled_by_restaurant = 1, cancellation_reason = :cancellationReason, order_cancelled_at = :date WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    void updateOrderCancelledByRestaurantFlagForOrder(Integer restaurantOrderId, String cancellationReason, Date date);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_order SET is_order_cancelled_by_customer = 1, cancellation_reason = :cancellationReason, order_cancelled_at = :date WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    void updateOrderCancelledByCustomerFlagForOrder(Integer restaurantOrderId, String cancellationReason, Date date);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_payment_confirmed=1 AND is_order_accepted_by_restaurant = 1 AND is_order_started_preparing_by_restaurant = 0 AND is_order_food_ready_by_restaurant = 0 AND is_order_out_for_delivery = 0 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    List<RestaurantOrder> findAcceptedOrdersForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_payment_confirmed=1 AND is_order_accepted_by_restaurant = 1 AND is_order_started_preparing_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 0 AND is_order_out_for_delivery = 0 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    List<RestaurantOrder> findOrdersInFoodPreparationForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_accepted_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 1 AND is_order_out_for_delivery = 0 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    List<RestaurantOrder> findFoodReadyOrdersForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_accepted_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 1 AND is_order_out_for_delivery = 1 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    List<RestaurantOrder> findOutForDeliveryOrdersForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_accepted_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 1 AND is_order_out_for_delivery = 1 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 1", nativeQuery = true)
    List<RestaurantOrder> findDeliveredOrdersForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND (order_date between :fromDate AND :toDate) AND is_order_accepted_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 1 AND is_order_out_for_delivery = 1 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 1", nativeQuery = true)
    List<RestaurantOrder> findDeliveredOrdersForARestaurant(String restaurantTenantId, Integer fromDate, Integer toDate);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND (is_order_cancelled_by_restaurant = 1 OR is_order_cancelled_by_customer = 1)", nativeQuery = true)
    List<RestaurantOrder> findCancelledOrdersForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND (order_date between :fromDate AND :toDate) AND (is_order_cancelled_by_restaurant = 1 OR is_order_cancelled_by_customer = 1)", nativeQuery = true)
    List<RestaurantOrder> findCancelledOrdersForARestaurant(String restaurantTenantId, Integer fromDate, Integer toDate);

    @Query(value = "SELECT * FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_payment_confirmed=1 AND is_order_accepted_by_restaurant = 0 AND is_order_food_ready_by_restaurant = 0 AND is_order_out_for_delivery = 0 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    List<RestaurantOrder> findQueuedOrdersForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT MAX(order_grand_total) FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date", nativeQuery = true)
    Double findHighestOrderValueToday(String restaurantTenantId, Integer date);

    @Query(value = "SELECT SUM(order_grand_total) FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date", nativeQuery = true)
    Double findRevenueToday(String restaurantTenantId, Integer date);

    @Query(value = "SELECT SUM(order_grand_total) FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date >= :startDate AND order_date <= :endDate", nativeQuery = true)
    Double findRevenueThisMonth(String restaurantTenantId, Integer startDate, Integer endDate);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_order SET is_order_started_preparing_by_restaurant = :newValue, order_started_preparing_at = :date WHERE restaurant_order_id = :restaurantOrderId", nativeQuery = true)
    void updateIsOrderStartedPreparingByRestaurantForOrder(Integer restaurantOrderId, Integer newValue, Date date);


    @Query(value = "SELECT COUNT(*) FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_accepted_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 0 AND is_order_out_for_delivery = 0 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    Long findAcceptedOrdersCountForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT COUNT(*) FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_payment_confirmed=1 AND is_order_accepted_by_restaurant = 1 AND is_order_started_preparing_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 0 AND is_order_out_for_delivery = 0 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    Long findOrdersInFoodPreparationCountForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT COUNT(*) FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_accepted_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 1 AND is_order_out_for_delivery = 0 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    Long findFoodReadyOrdersCountForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT COUNT(*) FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_accepted_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 1 AND is_order_out_for_delivery = 1 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    Long findOutForDeliveryOrdersCountForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT COUNT(*) FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_accepted_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 1 AND is_order_out_for_delivery = 1 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 1", nativeQuery = true)
    Long findDeliveredOrdersCountForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT COUNT(*) FROM restaurant_order WHERE (restaurant_outlet_tenant_id = :restaurantTenantId AND is_order_cancelled_by_restaurant = 1 AND order_date = :date) OR (restaurant_outlet_tenant_id = :restaurantTenantId AND is_order_cancelled_by_customer = 1 AND order_date = :date)", nativeQuery = true)
    Long findCancelledOrdersCountForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT COUNT(*) FROM restaurant_order WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND order_date = :date AND is_order_payment_confirmed=1 AND is_order_accepted_by_restaurant = 0 AND is_order_food_ready_by_restaurant = 0 AND is_order_out_for_delivery = 0 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    Long findQueuedOrdersCountForARestaurant(String restaurantTenantId, Integer date);

    @Query(value = "SELECT * FROM restaurant_order WHERE customer_tenant_id = :customerTenantId AND is_order_accepted_by_restaurant = 1 AND is_order_food_ready_by_restaurant = 1 AND is_order_out_for_delivery = 1 AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 1", nativeQuery = true)
    List<RestaurantOrder> findPastOrdersOfACustomer(String customerTenantId);

    @Query(value = "SELECT * FROM restaurant_order WHERE customer_tenant_id = :customerTenantId AND is_order_cancelled_by_restaurant = 0 AND is_order_cancelled_by_customer = 0 AND is_order_delivered = 0", nativeQuery = true)
    List<RestaurantOrder> findActiveOrdersOfACustomer(String customerTenantId);
}
