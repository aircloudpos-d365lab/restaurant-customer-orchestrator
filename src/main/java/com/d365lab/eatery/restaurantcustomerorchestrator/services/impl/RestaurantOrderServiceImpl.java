package com.d365lab.eatery.restaurantcustomerorchestrator.services.impl;

import com.d365lab.eatery.restaurantcustomerorchestrator.controllers.RestaurantOrchestratorController;
import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantCodOrder;
import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantOrder;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.Item;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderDetails;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderInputPayload;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderOutputPayload;
import com.d365lab.eatery.restaurantcustomerorchestrator.repositories.RestaurantCodOrderRepository;
import com.d365lab.eatery.restaurantcustomerorchestrator.repositories.RestaurantOrderRepository;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.CartService;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrderService;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.RestaurantCustomerOrchestratorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RestaurantOrderServiceImpl implements RestaurantOrderService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantOrderServiceImpl.class);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private RestaurantOrderRepository restaurantOrderRepository;

    @Autowired
    private RestaurantCodOrderRepository restaurantCodOrderRepository;

    @Autowired
    private CartService cartService;

    @Override
    public List<RestaurantOrder> getAllOrdersForARestaurant(String restaurantTenantId, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<RestaurantOrder> pagedResultForOrdersForARestaurant = restaurantOrderRepository.findAllOrdersForRestaurantWithPagination(restaurantTenantId, paging);
        if (pagedResultForOrdersForARestaurant.hasContent()) {
            return pagedResultForOrdersForARestaurant.getContent();
        } else {
            return new ArrayList<RestaurantOrder>();
        }
    }

    @Override
    public RestaurantOrderOutputPayload createRestaurantOrder(RestaurantOrderInputPayload restaurantOrderPayload) throws RestaurantCustomerOrchestratorException {
        RestaurantOrder restaurantOrder = new RestaurantOrder();
        RestaurantOrderOutputPayload persistedRestaurantOrderOutput = new RestaurantOrderOutputPayload();
        restaurantOrder.setRestaurantTenantId(restaurantOrderPayload.getRestaurantTenantId());
        restaurantOrder.setCartId(restaurantOrderPayload.getCartId());
        restaurantOrder.setOrderTotal(restaurantOrderPayload.getOrderTotal());
        restaurantOrder.setCustomerTenantId(restaurantOrderPayload.getCustomerTenantId());
        restaurantOrder.setOrderChannel(restaurantOrderPayload.getOrderChannel());
        restaurantOrder.setOrderPaymentMode(restaurantOrderPayload.getOrderPaymentMode());
        restaurantOrder.setOrderSpecialInstructions(restaurantOrderPayload.getOrderSpecialInstructions());
        restaurantOrder.setOrderDiscountTotal(restaurantOrderPayload.getOrderDiscountTotal());
        restaurantOrder.setOrderGrandTotal(restaurantOrderPayload.getOrderGrandTotal());
        restaurantOrder.setIsOrderAcceptedByRestaurant(restaurantOrderPayload.getIsOrderAcceptedByRestaurant());
        restaurantOrder.setIsOrderPaymentConfirmed(restaurantOrderPayload.getIsOrderPaymentConfirmed());
        restaurantOrder.setIsOrderPreparedByRestaurant(restaurantOrderPayload.getIsOrderPreparedByRestaurant());
        restaurantOrder.setIsOrderDelivered(restaurantOrderPayload.getIsOrderDelivered());
        restaurantOrder.setIsOrderOutForDelivery(restaurantOrderPayload.getIsOrderOutForDelivery());
        restaurantOrder.setOrderAppliedCoupon(restaurantOrderPayload.getOrderAppliedCoupon());
        restaurantOrder.setOrderDeliveryAddress(restaurantOrderPayload.getOrderDeliveryAddress());
        restaurantOrder.setRestaurantOrderMode(restaurantOrderPayload.getRestaurantOrderMode());
        restaurantOrder.setOrderTotalCgstPercentage(restaurantOrderPayload.getOrderTotalCgstPercentage());
        restaurantOrder.setOrderTotalSgstPercentage(restaurantOrderPayload.getOrderTotalSgstPercentage());
        restaurantOrder.setOrderDate(Integer.parseInt(sdf.format(new Date())));
        restaurantOrder.setIsOrderCancelledByCustomer(restaurantOrderPayload.getIsOrderCancelledByCustomer());
        restaurantOrder.setIsOrderCancelledByRestaurant(restaurantOrderPayload.getIsOrderCancelledByRestaurant());
        restaurantOrder.setIsOrderStartedPreparingByRestaurant(restaurantOrderPayload.getIsOrderStartedPreparingByRestaurant());
//        if (restaurantOrderPayload.getOrderPaymentMode().equalsIgnoreCase("CASH")) {
//            RestaurantCodOrder restaurantCodOrder = restaurantCodOrderRepository.save(new RestaurantCodOrder());
//        }
        RestaurantOrder persistedRestaurantOrder = null;
        try {
            if (restaurantOrder != null)
                persistedRestaurantOrder = restaurantOrderRepository.save(restaurantOrder);
        }
        catch (Exception e) {
            LOGGER.error("Exception: {} occurred while persisting restaurant-order for cart: {}", e.getMessage(), restaurantOrderPayload.getCartId());
            throw new RestaurantCustomerOrchestratorException(e.getMessage());
        }
        List<Item> orderedItemList = null;
        if (persistedRestaurantOrder == null) {
            // Do Nothing
        } else {
            if (restaurantOrderPayload.getOrderPaymentMode().equalsIgnoreCase("COD")) {
                RestaurantCodOrder restaurantCodOrder = restaurantCodOrderRepository.save(new RestaurantCodOrder(persistedRestaurantOrder.getRestaurantOrderId(),
                        0,
                        persistedRestaurantOrder.getOrderGrandTotal(),
                        persistedRestaurantOrder.getRestaurantTenantId()));
            }
            Integer persistedOrderId = persistedRestaurantOrder.getRestaurantOrderId();
            restaurantOrderRepository.updateInvoiceNumberForOrder(persistedOrderId);
            persistedRestaurantOrder = restaurantOrderRepository.findRestaurantOrderDetails(persistedOrderId);
            orderedItemList = cartService.getItemListOfACart(persistedRestaurantOrder.getCartId().toString(), 0);
        }
        persistedRestaurantOrderOutput.setRestaurantOrder(persistedRestaurantOrder);
        persistedRestaurantOrderOutput.setOrderMenuList(orderedItemList);
        return persistedRestaurantOrderOutput;
    }

    @Override
    public void updateOrderAcceptedByRestaurantFlagForOrder(Integer restaurantOrderId, Integer newValue) {
        restaurantOrderRepository.updateOrderAcceptedFlagForOrder(restaurantOrderId, newValue, new Date());
    }

    @Override
    public void updateOrderPreparedFlagForOrder(Integer restaurantOrderId, Integer newValue) {
        restaurantOrderRepository.updateOrderPreparedFlagForOrder(restaurantOrderId, newValue, new Date());
    }

    @Override
    public void updatePaymentConfirmedFlagForOrder(Integer restaurantOrderId, Integer newValue) {
        restaurantOrderRepository.updatePaymentConfirmedFlagForOrder(restaurantOrderId, newValue);
    }

    @Override
    public void updateDeliveredFlagForOrder(Integer restaurantOrderId, Integer newValue) {
        RestaurantCodOrder checkIfCod = restaurantCodOrderRepository.findIfCodOrderExists(restaurantOrderId);
        if (checkIfCod == null) {
            restaurantOrderRepository.updateDeliveredFlagForOrder(restaurantOrderId, newValue, new Date());
        }
    }

    @Override
    public void updateDeliveredFlagForCodOrder(Integer restaurantOrderId, Integer newValue, String amountCollectedThrough) {
        RestaurantCodOrder checkIfCod = restaurantCodOrderRepository.findIfCodOrderExists(restaurantOrderId);
        if (checkIfCod != null) {
            restaurantCodOrderRepository.updateAmountCollectionForCodOrder(restaurantOrderId, newValue, amountCollectedThrough, new Date());
            restaurantOrderRepository.updateDeliveredFlagForOrder(restaurantOrderId, newValue, new Date());
        }
    }

    @Override
    public void updateIsOrderStartedPreparingByRestaurantFlagForOrder(Integer restaurantOrderId, Integer newValue) {
        restaurantOrderRepository.updateIsOrderStartedPreparingByRestaurantForOrder(restaurantOrderId, newValue, new Date());
    }

    @Override
    public void updateOutForDeliveryFlagForOrder(Integer restaurantOrderId, Integer newValue) {
        restaurantOrderRepository.updateOutForDeliveryFlagForOrder(restaurantOrderId, newValue, new Date());
    }

    @Override
    public RestaurantOrder getOrderDetails(Integer restaurantOrderId) {
        return restaurantOrderRepository.findRestaurantOrderDetails(restaurantOrderId);
    }

    @Override
    public void updateCancelledByRestaurantFlagForOrder(Integer restaurantOrderId, String cancellationReason) {
        restaurantOrderRepository.updateOrderCancelledByRestaurantFlagForOrder(restaurantOrderId, cancellationReason, new Date());
    }

    @Override
    public void updateCancelledByCustomerFlagForOrder(Integer restaurantOrderId, String cancellationReason) {
        restaurantOrderRepository.updateOrderCancelledByCustomerFlagForOrder(restaurantOrderId, cancellationReason, new Date());
    }

    @Override
    public List<RestaurantOrderOutputPayload> getAllAcceptedOrderForARestaurant(String restaurantTenantId) throws RestaurantCustomerOrchestratorException {
        try {
            if (restaurantTenantId != null) {
                Integer date;
                try {
                    date = Integer.parseInt(sdf.format(new Date()));
                } catch (Exception e) {
                    throw new RestaurantCustomerOrchestratorException("Date: " + sdf.format(new Date()) + " could not be parsed.");
                }
                List<RestaurantOrderOutputPayload> acceptedOrderList = new ArrayList<>();
                List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findAcceptedOrdersForARestaurant(restaurantTenantId, date);
                if (restaurantOrderList.isEmpty()) {
                    return null;
                } else {
                    restaurantOrderList.stream().forEach(order -> {
                        List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
                        acceptedOrderList.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
                    });
                    return acceptedOrderList;
                }
            } else {
                throw new RestaurantCustomerOrchestratorException("Restaurant-Tenant-Id can not be NULL");
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception: {} occurred while fetching accepted-order-list for the restaurant: {}", e.getMessage(), restaurantTenantId);
            throw new RestaurantCustomerOrchestratorException(e.getMessage());
        }
    }

    @Override
    public List<RestaurantOrderOutputPayload> getAllOrdersInFoodPreparationForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        List<RestaurantOrderOutputPayload> orderInFoodPreparationList = new ArrayList<>();
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findOrdersInFoodPreparationForARestaurant(restaurantTenantId, date);
        restaurantOrderList.stream().forEach( order -> {
            List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
            orderInFoodPreparationList.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
        });
        return orderInFoodPreparationList;
    }

    @Override
    public List<RestaurantOrderOutputPayload> getAllFoodReadyOrderForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        List<RestaurantOrderOutputPayload> foodReadyOrderList = new ArrayList<>();
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findFoodReadyOrdersForARestaurant(restaurantTenantId, date);
        restaurantOrderList.stream().forEach( order -> {
            List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
            foodReadyOrderList.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
        });
        return foodReadyOrderList;
    }

    @Override
    public List<RestaurantOrderOutputPayload> getAllOutForDeliveryOrderForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        List<RestaurantOrderOutputPayload> outForDeliveryOrderList = new ArrayList<>();
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findOutForDeliveryOrdersForARestaurant(restaurantTenantId, date);
        restaurantOrderList.stream().forEach( order -> {
            List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
            outForDeliveryOrderList.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
        });
        return outForDeliveryOrderList;
    }

    @Override
    public List<RestaurantOrderOutputPayload> getAllDeliveredOrderForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        List<RestaurantOrderOutputPayload> deliveredOrderList = new ArrayList<>();
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findDeliveredOrdersForARestaurant(restaurantTenantId, date);
        restaurantOrderList.stream().forEach( order -> {
            List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
            deliveredOrderList.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
        });
        return deliveredOrderList;
    }

    @Override
    public List<RestaurantOrderOutputPayload> getAllDeliveredOrderForARestaurant(String restaurantTenantId, String fromDate, String toDate) {
        Integer fromDateIdx = Integer.parseInt(fromDate.replaceAll("-",""));
        Integer toDateIdx = Integer.parseInt(toDate.replaceAll("-",""));
        List<RestaurantOrderOutputPayload> deliveredOrderList = new ArrayList<>();
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findDeliveredOrdersForARestaurant(restaurantTenantId, fromDateIdx, toDateIdx);
        restaurantOrderList.stream().forEach( order -> {
            List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
            deliveredOrderList.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
        });
        return deliveredOrderList;
    }

    @Override
    public List<RestaurantOrderOutputPayload> getAllCancelledOrderForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        List<RestaurantOrderOutputPayload> cancelledOrderList = new ArrayList<>();
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findCancelledOrdersForARestaurant(restaurantTenantId, date);
        restaurantOrderList.stream().forEach( order -> {
            List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
            cancelledOrderList.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
        });
        return cancelledOrderList;
    }

    @Override
    public List<RestaurantOrderOutputPayload> getAllCancelledOrderForARestaurant(String restaurantTenantId, String fromDate, String toDate) {
        Integer fromDateIdx = Integer.parseInt(fromDate.replaceAll("-",""));
        Integer toDateIdx = Integer.parseInt(toDate.replaceAll("-",""));
        List<RestaurantOrderOutputPayload> cancelledOrderList = new ArrayList<>();
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findCancelledOrdersForARestaurant(restaurantTenantId, fromDateIdx, toDateIdx);
        restaurantOrderList.stream().forEach( order -> {
            List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
            cancelledOrderList.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
        });
        return cancelledOrderList;
    }

    @Override
    public List<RestaurantOrderOutputPayload> getAllQueuedOrderForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        List<RestaurantOrderOutputPayload> queuedOrderList = new ArrayList<>();
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findQueuedOrdersForARestaurant(restaurantTenantId, date);
        restaurantOrderList.stream().forEach( order -> {
            List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
            queuedOrderList.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
        });
        return queuedOrderList;
    }

    @Override
    public Double getHighestOrderForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        Double highestOrderToday = 0D;
        highestOrderToday = restaurantOrderRepository.findHighestOrderValueToday(restaurantTenantId, date);
        return highestOrderToday;
    }

    @Override
    public Double getRevenueForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        Double revenueToday = 0D;
        revenueToday = restaurantOrderRepository.findRevenueToday(restaurantTenantId, date);
        return revenueToday;
    }

    @Override
    public Double getRevenueThisMonthForARestaurant(String restaurantTenantId) {
        Integer startDate = Integer.parseInt(sdf.format(
                java.sql.Date.valueOf(LocalDate.now()
                .with(TemporalAdjusters.firstDayOfMonth()))));
        Integer endDate = Integer.parseInt(sdf.format(new Date()));
        Double revenueThisMonth = 0D;
        revenueThisMonth = restaurantOrderRepository.findRevenueThisMonth(restaurantTenantId, startDate, endDate);
        return revenueThisMonth;
    }

    @Override
    public Long getAllAcceptedOrderCountForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        Long acceptedCount = 0L;
        acceptedCount = restaurantOrderRepository.findAcceptedOrdersCountForARestaurant(restaurantTenantId, date);
        return acceptedCount;
    }

    @Override
    public Long getAllOrderInPreparationCountForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        Long orderCount = 0L;
        orderCount = restaurantOrderRepository.findOrdersInFoodPreparationCountForARestaurant(restaurantTenantId, date);
        return orderCount;
    }

    @Override
    public Long getAllFoodReadyOrderCountForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        Long orderCount = 0L;
        orderCount = restaurantOrderRepository.findFoodReadyOrdersCountForARestaurant(restaurantTenantId, date);
        return orderCount;
    }

    @Override
    public Long getAllOuForDeliveryOrderCountForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        Long orderCount = 0L;
        orderCount = restaurantOrderRepository.findOutForDeliveryOrdersCountForARestaurant(restaurantTenantId, date);
        return orderCount;
    }

    @Override
    public Long getCancelledOrderCountForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        Long orderCount = 0L;
        orderCount = restaurantOrderRepository.findCancelledOrdersCountForARestaurant(restaurantTenantId, date);
        return orderCount;
    }

    @Override
    public Long getAllDeliveredOrderCountForARestaurant(String restaurantTenantId) {
        Integer date = Integer.parseInt(sdf.format(new Date()));
        Long orderCount = 0L;
        orderCount = restaurantOrderRepository.findDeliveredOrdersCountForARestaurant(restaurantTenantId, date);
        return orderCount;
    }

    @Override
    public RestaurantOrder getOrderDetailsForOrderId(String restaurantOrderId) throws RestaurantCustomerOrchestratorException {
        try {
            if (restaurantOrderId == null || restaurantOrderId.isEmpty()) {
                throw new RestaurantCustomerOrchestratorException("Restaurant-Order-Id can not be null!");
            }
            else {
                RestaurantOrder restaurantOrder = getOrderDetails(Integer.parseInt(restaurantOrderId));
                if (restaurantOrder == null) {
                    return null;
                }
                else {
                    return restaurantOrder;
                }
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception: {} occurred while fetching order information for order-id: {}", e.getMessage(), restaurantOrderId);
            throw new RestaurantCustomerOrchestratorException(e.getMessage());
        }
    }

    @Override
    public RestaurantOrderDetails getAllPastOrdersForACustomer(String customerTenantId) throws RestaurantCustomerOrchestratorException {
        try {
            if (customerTenantId == null || customerTenantId.isEmpty()) {
                throw new RestaurantCustomerOrchestratorException("Customer-Tenant-Id can not be empty or Null!");
            }
            else {
                List<RestaurantOrderOutputPayload> pastOrderListOfCustomer = new ArrayList<>();
                List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findPastOrdersOfACustomer(customerTenantId);
                if (restaurantOrderList == null || restaurantOrderList.isEmpty()) {
                    return null;
                }
                else {
                    restaurantOrderList.stream().forEach( order -> {
                        List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
                        pastOrderListOfCustomer.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
                    });
                    return new RestaurantOrderDetails(pastOrderListOfCustomer);
                }
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception: {} occurred while fetching past-order information for customer: {}", e.getMessage(), customerTenantId);
            throw new RestaurantCustomerOrchestratorException(e.getMessage());
        }
    }

    @Override
    public RestaurantOrderDetails getAllActiveOrdersForACustomer(String customerTenantId) throws RestaurantCustomerOrchestratorException {
        try {
            if (customerTenantId == null || customerTenantId.isEmpty()) {
                throw new RestaurantCustomerOrchestratorException("Customer-Tenant-Id can not be empty or Null!");
            }
            else {
                List<RestaurantOrderOutputPayload> activeOrderListOfCustomer = new ArrayList<>();
                List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findActiveOrdersOfACustomer(customerTenantId);
                if (restaurantOrderList == null || restaurantOrderList.isEmpty()) {
                    return null;
                }
                else {
                    restaurantOrderList.stream().forEach( order -> {
                        List<Item> itemListOfOrder = cartService.getItemListOfACart(order.getCartId().toString(), 0);
                        activeOrderListOfCustomer.add(new RestaurantOrderOutputPayload(order, itemListOfOrder));
                    });
                    return new RestaurantOrderDetails(activeOrderListOfCustomer);
                }
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception: {} occurred while fetching active-order information for customer: {}", e.getMessage(), customerTenantId);
            throw new RestaurantCustomerOrchestratorException(e.getMessage());
        }
    }

}
