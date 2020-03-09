package com.d365lab.eatery.restaurantcustomerorchestrator.services.impl;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantOrder;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.Item;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.OrderInvoice;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantDetails;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.CartService;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.InvoiceGenerationService;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrchestratorService;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class InvoiceGenerationServiceImpl implements InvoiceGenerationService {

    @Autowired
    private RestaurantOrderService restaurantOrderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private RestaurantOrchestratorService restaurantOrchestratorService;

    @Override
    public OrderInvoice generateInvoice(Integer restaurantOrderId) {
        if (restaurantOrderId != null) {
            OrderInvoice orderInvoice = new OrderInvoice();
            RestaurantOrder restaurantOrderDetails = restaurantOrderService.getOrderDetails(restaurantOrderId);
            RestaurantDetails restaurantDetails = restaurantOrchestratorService.getRestaurantDetailsForRestaurant(restaurantOrderDetails.getRestaurantTenantId());
            List<Item> itemList = cartService.getItemListOfACart(restaurantOrderDetails.getCartId().toString(), 0);
            orderInvoice.setOrderInvoiceId(restaurantOrderDetails.getOrderInvoiceId());
            orderInvoice.setRestaurantBrandName(restaurantDetails.getRestaurantBrandName());
            orderInvoice.setRestaurantOutletName(restaurantDetails.getRestaurantOutletName());
            orderInvoice.setRestaurantGstNumber(restaurantDetails.getRestaurantGstNumber());
            orderInvoice.setRestaurantFssaiLicenseNumber(restaurantDetails.getRestaurantFssaiLicenseNumber());
            orderInvoice.setCustomerMobileNumber("XXXXXXXXXX");
            orderInvoice.setOrderDeliveryAddress(restaurantOrderDetails.getOrderDeliveryAddress());
            orderInvoice.setOrderCouponApplied(restaurantOrderDetails.getOrderAppliedCoupon());
            orderInvoice.setOrderedItemList(itemList);
            orderInvoice.setOrderedVia(restaurantOrderDetails.getRestaurantOrderMode());
            orderInvoice.setOrderTotal(restaurantOrderDetails.getOrderTotal());
            orderInvoice.setOrderDiscountTotal(restaurantOrderDetails.getOrderDiscountTotal());
            orderInvoice.setOrderGrandTotal(restaurantOrderDetails.getOrderGrandTotal());
            orderInvoice.setOrderTotalCgst(BigDecimal.valueOf(restaurantOrderDetails.getOrderTotal())
                    .multiply(BigDecimal.valueOf(restaurantOrderDetails.getOrderTotalCgstPercentage()))
                    .divide(BigDecimal.valueOf(100L))
                    .setScale(2, RoundingMode.HALF_UP).doubleValue());
            orderInvoice.setOrderTotalSgst(BigDecimal.valueOf(restaurantOrderDetails.getOrderTotal())
                    .multiply(BigDecimal.valueOf(restaurantOrderDetails.getOrderTotalSgstPercentage()))
                    .divide(BigDecimal.valueOf(100L))
                    .setScale(2, RoundingMode.HALF_UP).doubleValue());
            orderInvoice.setOrderPaidBy(restaurantOrderDetails.getOrderPaymentMode());
            return orderInvoice;
        }
        else {
            return null;
        }
    }
}
