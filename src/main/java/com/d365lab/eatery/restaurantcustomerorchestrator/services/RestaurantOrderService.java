package com.d365lab.eatery.restaurantcustomerorchestrator.services;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantOrder;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderDetails;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderInputPayload;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderOutputPayload;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.RestaurantCustomerOrchestratorException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface RestaurantOrderService {

    List<RestaurantOrder> getAllOrdersForARestaurant(String restaurantTenantId, Integer pageNo, Integer pageSize, String sortBy);

    RestaurantOrderOutputPayload createRestaurantOrder(RestaurantOrderInputPayload restaurantOrderPayload) throws RestaurantCustomerOrchestratorException;

    void updateOrderAcceptedByRestaurantFlagForOrder(Integer restaurantOrderId, Integer newValue);

    void updateOrderPreparedFlagForOrder(Integer restaurantOrderId, Integer newValue);

    void updatePaymentConfirmedFlagForOrder(Integer restaurantOrderId, Integer newValue);

    void updateDeliveredFlagForOrder(Integer restaurantOrderId, Integer newValue);

    void updateDeliveredFlagForCodOrder(Integer restaurantOrderId, Integer newValue, String amountCollectedThrough);

    void updateIsOrderStartedPreparingByRestaurantFlagForOrder(Integer restaurantOrderId, Integer newValue);

    void updateOutForDeliveryFlagForOrder(Integer restaurantOrderId, Integer newValue);

    RestaurantOrder getOrderDetails(Integer restaurantOrderId);

    void updateCancelledByRestaurantFlagForOrder(Integer restaurantOrderId, String cancellationReason);

    void updateCancelledByCustomerFlagForOrder(Integer restaurantOrderId, String cancellationReason);

    List<RestaurantOrderOutputPayload> getAllAcceptedOrderForARestaurant(String restaurantTenantId) throws RestaurantCustomerOrchestratorException;

    List<RestaurantOrderOutputPayload> getAllOrdersInFoodPreparationForARestaurant(String restaurantTenantId);

    List<RestaurantOrderOutputPayload> getAllFoodReadyOrderForARestaurant(String restaurantTenantId);

    List<RestaurantOrderOutputPayload> getAllOutForDeliveryOrderForARestaurant(String restaurantTenantId);

    List<RestaurantOrderOutputPayload> getAllDeliveredOrderForARestaurant(String restaurantTenantId);

    List<RestaurantOrderOutputPayload> getAllDeliveredOrderForARestaurant(String restaurantTenantId, String fromDate, String toDate);

    List<RestaurantOrderOutputPayload> getAllCancelledOrderForARestaurant(String restaurantTenantId);

    List<RestaurantOrderOutputPayload> getAllCancelledOrderForARestaurant(String restaurantTenantId, String fromDate, String toDate);

    List<RestaurantOrderOutputPayload> getAllQueuedOrderForARestaurant(String restaurantTenantId);

    Double getHighestOrderForARestaurant(String restaurantTenantId);

    Double getRevenueForARestaurant(String restaurantTenantId);

    Double getRevenueThisMonthForARestaurant(String restaurantTenantId);

    Long getAllAcceptedOrderCountForARestaurant(String restaurantTenantId);

    Long getAllOrderInPreparationCountForARestaurant(String restaurantTenantId);

    Long getAllFoodReadyOrderCountForARestaurant(String restaurantTenantId);

    Long getAllOuForDeliveryOrderCountForARestaurant(String restaurantTenantId);

    Long getCancelledOrderCountForARestaurant(String restaurantTenantId);

    Long getAllDeliveredOrderCountForARestaurant(String restaurantTenantId);

    RestaurantOrder getOrderDetailsForOrderId(String restaurantOrderId) throws RestaurantCustomerOrchestratorException;

    RestaurantOrderDetails getAllPastOrdersForACustomer(String customerTenantId) throws RestaurantCustomerOrchestratorException;

    RestaurantOrderDetails getAllActiveOrdersForACustomer(String customerTenantId) throws RestaurantCustomerOrchestratorException;
}
