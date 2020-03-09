package com.d365lab.eatery.restaurantcustomerorchestrator.controllers;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenuCategory;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.RestaurantCustomerOrchestratorException;
import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.d365lab.eatery.restaurantcustomerorchestrator.utils.constants.RestaurantCustomerOrchestratorConstants.CACHE_INGESTION_MAX_RETRY_COUNT;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestaurantOrchestratorController {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantOrchestratorController.class);
    private static final Gson gson = new Gson();
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private RestaurantOrchestratorService restaurantOrchestratorService;

    @Autowired
    private RestaurantOrderService restaurantOrderService;

    @Autowired
    private RestaurantMenuCategoryService restaurantMenuCategoryService;

    @Autowired
    private InvoiceGenerationService invoiceGenerationService;

    @Autowired
    private CartService cartService;

//
//    @PostMapping(value = "/temporary-cart-before-checkout/add", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<TemporaryCartToPersistInRedis> persistTemporaryCartIntoCache(@RequestBody TemporaryCartToPersistInRedis temporaryCartToPersistInRedis) {
//        TemporaryCartToPersistInRedis temporaryCart = null;
//        try {
//            temporaryCart = restaurantOrchestratorService.persistTemporaryCartIntoCache(temporaryCartToPersistInRedis);
//        } catch (Exception e) {
//            LOGGER.error("Exception:{} occurred while persisting temporary cart: {}", e.getMessage(), temporaryCartToPersistInRedis.toString());
//            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        if (temporaryCart == null) {
//            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<TemporaryCartToPersistInRedis>(temporaryCart, HttpStatus.OK);
//    }


    // Get Restaurant-Menu in the form of Cart-Restaurant-Menu
    @RequestMapping(value = "/restaurant-menu-for-customer-cart", method = RequestMethod.GET)
    public ResponseEntity<CartMenu> convertRestaurantMenuToCartRestaurantMenu(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        RestaurantDetails restaurantDetails;
        try {
            restaurantDetails = restaurantOrchestratorService.getRestaurantDetailsForRestaurant(restaurantTenantId);
            if (restaurantDetails == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            List<Item> initializedCartWithMenu = restaurantOrchestratorService.convertRestaurantMenuToCartMenu(restaurantDetails.getMenuList());
            if (initializedCartWithMenu.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            CartMenu cartMenu = new CartMenu(initializedCartWithMenu);
            return new ResponseEntity<CartMenu>(cartMenu, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception: {} occurred while converting restaurant-menu to cart-restaurant-menu for restaurant: {}", e.getMessage(), restaurantTenantId);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Restaurant Menu Category
//
//    @RequestMapping(value = "/restaurant-menu-category-list/", method = RequestMethod.GET)
//    public ResponseEntity<List<RestaurantMenuCategory>> listAllRestaurantMenuCategory() {
//        List<RestaurantMenuCategory> restaurantMenuCategoryList = restaurantMenuCategoryService.getAllMenuCategoryList();
//        if (restaurantMenuCategoryList.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//            // You may decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<RestaurantMenuCategory>>(restaurantMenuCategoryList, HttpStatus.OK);
//    }

    // Get All Restaurant-Menu for a Restaurant
//    @RequestMapping(value = "/restaurant-menu/", method = RequestMethod.GET)
//    public ResponseEntity<List<RestaurantMenu>> listAllRestaurantMenu(@RequestParam("restaurant_tenant_id") String restaurantTenantId,
//                                                                      @RequestParam(defaultValue = "0") Integer pageNo,
//                                                                      @RequestParam(defaultValue = "20") Integer pageSize,
//                                                                      @RequestParam(defaultValue = "restaurant_menu_id") String sortBy) {
//        List<RestaurantMenu> restaurantMenus = restaurantOrchestratorService.getRestaurantMenuForRestaurant(restaurantTenantId,
//                pageNo,
//                pageSize,
//                sortBy);
//        if (restaurantMenus.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<RestaurantMenu>>(restaurantMenus, HttpStatus.OK);
//    }

    // Get All Restaurant-Menu-Customization for a Restaurant-Menu
//
//    @RequestMapping(value = "/restaurant-menu-customization/", method = RequestMethod.GET)
//    public ResponseEntity<List<RestaurantMenuCustomization>> listAllRestaurantMenuCustomization(@RequestParam("restaurant_menu_id") Integer restaurantMenuId) {
//        List<RestaurantMenuCustomization> restaurantMenuCustomizations = restaurantOrchestratorService.getAllRestaurantMenuCustomizationForMenu(restaurantMenuId);
//        if (restaurantMenuCustomizations.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<RestaurantMenuCustomization>>(restaurantMenuCustomizations, HttpStatus.OK);
//    }

//    // Get All Restaurant-Order for a Restaurant
//    @RequestMapping(value = "/restaurant-order/", method = RequestMethod.GET)
//    public ResponseEntity<List<RestaurantOrder>> listAllRestaurantOrder(@RequestParam("restaurant_tenant_id") String restaurantTenantId,
//                                                                        @RequestParam(defaultValue = "0") Integer pageNo,
//                                                                        @RequestParam(defaultValue = "10") Integer pageSize,
//                                                                        @RequestParam(defaultValue = "restaurant_order_id") String sortBy) {
//        List<RestaurantOrder> restaurantOrders = restaurantOrderService.getAllOrdersForARestaurant(restaurantTenantId,
//                pageNo,
//                pageSize,
//                sortBy);
//        if (restaurantOrders.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<RestaurantOrder>>(restaurantOrders, HttpStatus.OK);
//    }

    // Get Restaurant-Payment-Options for a Restaurant
//
//    @RequestMapping(value = "/restaurant-payment-options/", method = RequestMethod.GET)
//    public ResponseEntity<List<RestaurantPaymentOptions>> listAllRestaurantPaymentOptions(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
//        List<RestaurantPaymentOptions> restaurantPaymentOptions = restaurantOrchestratorService.getRestaurantPaymentOptionsForRestaurant(restaurantTenantId);
//        if (restaurantPaymentOptions.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<RestaurantPaymentOptions>>(restaurantPaymentOptions, HttpStatus.OK);
//    }

    // Create a new Restaurant-Info
    @PostMapping(value = "/restaurant-info/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RestaurantInfo> createRestaurantInfoForARestaurant(@RequestBody RestaurantInfo restaurantInfoPayload) {
        RestaurantInfo restaurantInfo = null;
        try {
            restaurantInfo = restaurantOrchestratorService.addRestaurantInfoWithLogin(restaurantInfoPayload);
        } catch (RestaurantCustomerOrchestratorException e) {
            LOGGER.error("Exception:{} occurred while creating restaurant-info for restaurant:{}", e.getMessage(), restaurantInfoPayload.getRestaurantOutletTenantId());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (restaurantInfo == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<RestaurantInfo>(restaurantInfo, HttpStatus.OK);
    }

    // Create a new Restaurant-Payment-Options
    @PostMapping(value = "/restaurant-payment-options/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RestaurantPaymentOptions> createRestaurantPaymentOptionsForARestaurant(@RequestBody RestaurantPaymentOptions restaurantPaymentOptionsPayload) {
        RestaurantPaymentOptions restaurantPaymentOptions = null;
        try {
            restaurantPaymentOptions = restaurantOrchestratorService.addRestaurantPaymentOptions(restaurantPaymentOptionsPayload);
        } catch (RestaurantCustomerOrchestratorException e) {
            LOGGER.error("Exception:{} occurred while creating restaurant-payment-options for restaurant:{}", e.getMessage(), restaurantPaymentOptionsPayload.getRestaurantTenantId());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (restaurantPaymentOptions == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<RestaurantPaymentOptions>(restaurantPaymentOptions, HttpStatus.OK);
    }

    // Create a new Restaurant-Menu
    @PostMapping(value = "/restaurant-menu/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RestaurantMenuWithCustomization> createRestaurantMenuOfARestaurant(@RequestBody RestaurantMenuInputPayload restaurantMenuInputPayload) throws RestaurantCustomerOrchestratorException, ParseException {
        try {
            RestaurantMenuWithCustomization restaurantMenuWithCustomization = restaurantOrchestratorService.addRestaurantMenu(restaurantMenuInputPayload);
            if (restaurantMenuWithCustomization == null) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<RestaurantMenuWithCustomization>(restaurantMenuWithCustomization, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while creating restaurant-menu:{} for restaurant:{}", e.getMessage(), restaurantMenuInputPayload.getRestaurantMenuName(), restaurantMenuInputPayload.getRestaurantTenantId());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   // Update a Restaurant-Menu
   @PostMapping(value = "/restaurant-menu/update", consumes = "application/json", produces = "application/json")
   public ResponseEntity<RestaurantMenuWithCustomization> updateRestaurantMenuOfARestaurant(@RequestBody RestaurantMenuInputPayload restaurantMenuInputPayload) throws RestaurantCustomerOrchestratorException, ParseException {
       try {
           RestaurantMenuWithCustomization existingRestaurantMenuWithCustomization = restaurantOrchestratorService.getRestaurantMenuForMenuNameAndTenant(restaurantMenuInputPayload.getRestaurantMenuId(), restaurantMenuInputPayload.getRestaurantTenantId());

           if (existingRestaurantMenuWithCustomization == null) {
               RestaurantMenuWithCustomization restaurantMenuWithCustomization = restaurantOrchestratorService.addRestaurantMenu(restaurantMenuInputPayload);
               if (restaurantMenuWithCustomization == null) {
                   return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
               } else {
                   return new ResponseEntity<RestaurantMenuWithCustomization>(restaurantMenuWithCustomization, HttpStatus.OK);
               }
           } else {
               RestaurantMenuWithCustomization updatedRestaurantMenuWithCustomization = restaurantOrchestratorService.updateRestaurantMenu(existingRestaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuId(),
                       restaurantMenuInputPayload);
               if (updatedRestaurantMenuWithCustomization == null) {
                   return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
               } else {
                   return new ResponseEntity<RestaurantMenuWithCustomization>(updatedRestaurantMenuWithCustomization, HttpStatus.OK);
               }
           }
       }
       catch (Exception e) {
           LOGGER.error("Exception:{} occurred while updating restaurant-menu:{} for restaurant:{}", e.getMessage(), restaurantMenuInputPayload.getRestaurantMenuName(), restaurantMenuInputPayload.getRestaurantTenantId());
           return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

    // Reset and Enable a Restaurant-Menu
    @PostMapping(value = "/restaurant-menu/reset", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> resetRestaurantMenuOfARestaurantToActive(@RequestParam("restaurant_menu_id") String restaurantMenuId) throws RestaurantCustomerOrchestratorException {
        RestaurantMenuWithCustomization existingRestaurantMenuWithCustomization = null;
        try {
            existingRestaurantMenuWithCustomization = restaurantOrchestratorService.getRestaurantMenuWithCustomizationForAMenuId(restaurantMenuId);
            if (existingRestaurantMenuWithCustomization == null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            else {
                restaurantOrchestratorService.resetRestaurantMenuToActivate(restaurantMenuId);
                return ResponseEntity.ok(gson.toJson("Success"));
            }
        } catch (Exception e) {
            LOGGER.error("Exception:{} occurred while marking in-stock for restaurant-menu:{} for restaurant:{}", e.getMessage(), existingRestaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuName(), existingRestaurantMenuWithCustomization.getRestaurantMenu().getRestaurantTenantId());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Disable a Restaurant-Menu
    @PostMapping(value = "/restaurant-menu/disable", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> setRestaurantMenuOfARestaurantToDeactive(@RequestParam("restaurant_menu_id") String restaurantMenuId) throws RestaurantCustomerOrchestratorException {
        RestaurantMenuWithCustomization existingRestaurantMenuWithCustomization = null;
        try {
            if (restaurantMenuId != null) {
                existingRestaurantMenuWithCustomization = restaurantOrchestratorService.getRestaurantMenuWithCustomizationForAMenuId(restaurantMenuId);
                if (existingRestaurantMenuWithCustomization == null)
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                else {
                    restaurantOrchestratorService.setRestaurantMenuToDeactivate(restaurantMenuId);
                    return ResponseEntity.ok(gson.toJson("Success"));
                }
            }
            else {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            LOGGER.error("Exception:{} occurred while marking out-of-stock for restaurant-menu:{} for restaurant:{}", e.getMessage(), existingRestaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuName(), existingRestaurantMenuWithCustomization.getRestaurantMenu().getRestaurantTenantId());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    // Get a Single Restaurant-Details
    @RequestMapping(value = "/restaurant-details/", method = RequestMethod.GET)
    public ResponseEntity<RestaurantDetails> getRestaurantDetailsForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            RestaurantDetails restaurantDetails = restaurantOrchestratorService.getRestaurantDetailsForRestaurant(restaurantTenantId);
            if (restaurantDetails == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<RestaurantDetails>(restaurantDetails, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching restaurant-details for restaurant:{}", e.getMessage(), restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Get Menu with Menu Customizations
    @RequestMapping(value = "/restaurant-menu-and-customizations/", method = RequestMethod.GET)
    public ResponseEntity<RestaurantMenuOutputPayload> getRestaurantMenuWithCustomization(@RequestParam("restaurant_menu_id") String restaurantMenuId) {
        try {
            RestaurantMenuWithCustomization restaurantMenuWithCustomization = restaurantOrchestratorService.getRestaurantMenuWithCustomizationForAMenuId(restaurantMenuId);

            if (restaurantMenuWithCustomization == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            List<String> menuCustomizationList = new ArrayList<>();
            restaurantMenuWithCustomization.getRestaurantMenuCustomizationList().stream().forEach(cust -> {
                menuCustomizationList.add(cust.getRestaurantMenuCustomizationDescription());
            });
            String menuCustomizationListString = String.join(",", menuCustomizationList);
            RestaurantMenuOutputPayload restaurantMenuOutputPayload = new RestaurantMenuOutputPayload(
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuId(),
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantTenantId(),
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuName(),
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuDescription(),
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuType(),
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuCategory(),
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuPhoto(),
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuPrice(),
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuPriceCgstPercentage(),
                    restaurantMenuWithCustomization.getRestaurantMenu().getRestaurantMenuPriceSgstPercentage(),
                    menuCustomizationListString
            );
            return new ResponseEntity<RestaurantMenuOutputPayload>(restaurantMenuOutputPayload, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching restaurant-menu-and-customizations for restaurant-menu-id:{}", e.getMessage(), restaurantMenuId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update email in a Restaurant-Info
//    @RequestMapping(value = "/restaurant-info/update/email/", method = RequestMethod.PUT)
//    public ResponseEntity<String> updateRestaurantInfoForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId,
//                                                                             @RequestParam("restaurant_email") String restaurantEmailId) throws RestaurantCustomerOrchestratorException {
//        restaurantOrchestratorService.updateRestaurantEmailInfoForRestaurant(restaurantTenantId, restaurantEmailId);
//
//        return new ResponseEntity<String>("Restaurant Email is Updated Successfully!", HttpStatus.OK);
//    }



    // Create a Order for a Restaurant
    @PostMapping(value = "/restaurant-order/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RestaurantOrderOutputPayload> createRestaurantOrderOfARestaurant(@RequestBody RestaurantOrderInputPayload restaurantOrderInputPayload) throws RestaurantCustomerOrchestratorException {
        try {
            RestaurantOrderOutputPayload restaurantOrder = restaurantOrderService.createRestaurantOrder(restaurantOrderInputPayload);
            if (restaurantOrder == null) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<RestaurantOrderOutputPayload>(restaurantOrder, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while creating order for customer: {} regarding cart:{} for restaurant:{}", e.getMessage(),
                    restaurantOrderInputPayload.getCustomerTenantId(),
                    restaurantOrderInputPayload.getCartId(),
                    restaurantOrderInputPayload.getRestaurantTenantId());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Accept restaurant-order
    @PostMapping(value = "/restaurant-order/accept", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateRestaurantOrderAsAcceptedByRestaurant(@RequestParam("restaurant_order_id") String restaurantOrderId, @RequestParam("accept_flag_value") String acceptFlagValue) throws RestaurantCustomerOrchestratorException {
        try {
            RestaurantOrder existingRestaurantOrder = restaurantOrderService.getOrderDetails(Integer.parseInt(restaurantOrderId));
            if (existingRestaurantOrder == null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            else {
                restaurantOrderService.updateOrderAcceptedByRestaurantFlagForOrder(Integer.parseInt(restaurantOrderId), Integer.parseInt(acceptFlagValue));
                return ResponseEntity.ok(gson.toJson("Success"));
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while accepting order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mark food-preparation-start for order
    @PostMapping(value = "/restaurant-order/started-food-preparation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateRestaurantOrderAsStartedFoodPreparationByRestaurant(@RequestParam("restaurant_order_id") String restaurantOrderId, @RequestParam("started_food_preparation_flag_value") String startedFoodPreparationFlagValue) throws RestaurantCustomerOrchestratorException {
        try {
            RestaurantOrder existingRestaurantOrder = restaurantOrderService.getOrderDetails(Integer.parseInt(restaurantOrderId));
            if (existingRestaurantOrder == null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            else {
                restaurantOrderService.updateIsOrderStartedPreparingByRestaurantFlagForOrder(Integer.parseInt(restaurantOrderId), Integer.parseInt(startedFoodPreparationFlagValue));
                return ResponseEntity.ok(gson.toJson("Success"));
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while marking food-preparation-start for order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mark food-ready for order
    @PostMapping(value = "/restaurant-order/food-ready", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateRestaurantOrderAsFoodReadyByRestaurant(@RequestParam("restaurant_order_id") String restaurantOrderId, @RequestParam("food_ready_flag_value") String foodReadyFlagValue) throws RestaurantCustomerOrchestratorException {
        try {
            RestaurantOrder existingRestaurantOrder = restaurantOrderService.getOrderDetails(Integer.parseInt(restaurantOrderId));

            if (existingRestaurantOrder == null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            else {
                restaurantOrderService.updateOrderPreparedFlagForOrder(Integer.parseInt(restaurantOrderId), Integer.parseInt(foodReadyFlagValue));
                return ResponseEntity.ok(gson.toJson("Success"));
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while marking food-ready for order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mark out-for-delivery for order
    @PostMapping(value = "/restaurant-order/out-for-delivery", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateRestaurantOrderAsOutForDelivery(@RequestParam("restaurant_order_id") String restaurantOrderId, @RequestParam("out_for_delivery_flag_value") String outForDeliveryFlagValue) throws RestaurantCustomerOrchestratorException {
        try {
            RestaurantOrder existingRestaurantOrder = restaurantOrderService.getOrderDetails(Integer.parseInt(restaurantOrderId));
            if (existingRestaurantOrder == null)
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            else {
                restaurantOrderService.updateOutForDeliveryFlagForOrder(Integer.parseInt(restaurantOrderId), Integer.parseInt(outForDeliveryFlagValue));
                return ResponseEntity.ok(gson.toJson("Success"));
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while marking out-for-delivery for order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mark delivered for order
    @PostMapping(value = "/restaurant-order/delivered", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateRestaurantOrderAsDelivered(@RequestParam("restaurant_order_id") String restaurantOrderId, @RequestParam("delivered_flag_value") String deliveredFlagValue) throws Exception {
        try {
            RestaurantOrder existingRestaurantOrder = restaurantOrderService.getOrderDetails(Integer.parseInt(restaurantOrderId));
            if (existingRestaurantOrder == null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            else {
                try {
                    restaurantOrderService.updateDeliveredFlagForOrder(Integer.parseInt(restaurantOrderId), Integer.parseInt(deliveredFlagValue));
                }
                catch (Exception e) {
                    LOGGER.error("Exception: {} occurred while updating delivered-flag for order: {} for delivered-flag value: {}", e.getMessage(), restaurantOrderId, deliveredFlagValue);
                    return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
                }
                return ResponseEntity.ok(gson.toJson("Success"));
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while marking out-for-delivery for order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/restaurant-cod-order/delivered", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateRestaurantOrderAsDelivered(@RequestParam("restaurant_order_id") String restaurantOrderId,
                                                                   @RequestParam("delivered_flag_value") String deliveredFlagValue,
                                                                   @RequestParam("amount_collected_through") String amountCollectedThrough) throws RestaurantCustomerOrchestratorException {
        try {
            RestaurantOrder existingRestaurantOrder = restaurantOrderService.getOrderDetails(Integer.parseInt(restaurantOrderId));
            if (existingRestaurantOrder == null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            else {
                restaurantOrderService.updateDeliveredFlagForCodOrder(Integer.parseInt(restaurantOrderId),
                        Integer.parseInt(deliveredFlagValue),
                        amountCollectedThrough);
                return ResponseEntity.ok(gson.toJson("Success"));
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while marking out-for-delivered for COD-order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mark order-cancelled by Restaurant
    @PostMapping(value = "/restaurant-order/cancelled-by-restaurant", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateRestaurantOrderAsCancelledByRestaurant(@RequestParam("restaurant_order_id") String restaurantOrderId, @RequestParam("order_cancellation_reason") String orderCancellationReason) throws RestaurantCustomerOrchestratorException {
        try {
            RestaurantOrder existingRestaurantOrder = restaurantOrderService.getOrderDetails(Integer.parseInt(restaurantOrderId));
            if (existingRestaurantOrder == null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            else {
                restaurantOrderService.updateCancelledByRestaurantFlagForOrder(Integer.parseInt(restaurantOrderId), orderCancellationReason);
                return ResponseEntity.ok(gson.toJson("Success"));
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while marking cancelled-by-restaurant for order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mark order-cancelled by Customer
    @PostMapping(value = "/restaurant-order/cancelled-by-customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateRestaurantOrderAsCancelledByCustomer(@RequestParam("restaurant_order_id") String restaurantOrderId, @RequestParam("order_cancellation_reason") String orderCancellationReason) throws RestaurantCustomerOrchestratorException {
        try {
            RestaurantOrder existingRestaurantOrder = restaurantOrderService.getOrderDetails(Integer.parseInt(restaurantOrderId));

            if (existingRestaurantOrder == null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            else {
                restaurantOrderService.updateCancelledByCustomerFlagForOrder(Integer.parseInt(restaurantOrderId), orderCancellationReason);
                return ResponseEntity.ok(gson.toJson("Success"));
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while marking cancelled-by-customer for order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Accepted Restaurant Order
    @RequestMapping(value = "/restaurant-accepted-order-list", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantOrderOutputPayload>> listAllAcceptedRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            if (restaurantTenantId != null) {
                List<RestaurantOrderOutputPayload> restaurantAcceptedOrderList = restaurantOrderService.getAllAcceptedOrderForARestaurant(restaurantTenantId);
                if (restaurantAcceptedOrderList.isEmpty() || restaurantAcceptedOrderList == null) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                    // You may decide to return HttpStatus.NOT_FOUND
                }
                return new ResponseEntity<List<RestaurantOrderOutputPayload>>(restaurantAcceptedOrderList, HttpStatus.OK);
            }
            else {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching accepted-order list for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Under Food Preparation Restaurant Order
    @RequestMapping(value = "/restaurant-started-food-preparation-list", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantOrderOutputPayload>> listAllStartedFoodPreparationRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            List<RestaurantOrderOutputPayload> restaurantStartedFoodPreparationOrderList = restaurantOrderService.getAllOrdersInFoodPreparationForARestaurant(restaurantTenantId);
            if (restaurantStartedFoodPreparationOrderList.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<RestaurantOrderOutputPayload>>(restaurantStartedFoodPreparationOrderList, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching started-food-preparation-order list for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Food Ready Restaurant Order
    @RequestMapping(value = "/restaurant-food-ready-order-list", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantOrderOutputPayload>> listAllFoodReadyRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            List<RestaurantOrderOutputPayload> restaurantFoodReadyOrderList = restaurantOrderService.getAllFoodReadyOrderForARestaurant(restaurantTenantId);

            if (restaurantFoodReadyOrderList.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<RestaurantOrderOutputPayload>>(restaurantFoodReadyOrderList, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching food-ready-order list for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Get All Out-For-Delivery Restaurant Order
    @RequestMapping(value = "/restaurant-out-for-delivery-order-list", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantOrderOutputPayload>> listAllOutForDeliveryRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            List<RestaurantOrderOutputPayload> restaurantOutForDeliveryOrderList = restaurantOrderService.getAllOutForDeliveryOrderForARestaurant(restaurantTenantId);
            if (restaurantOutForDeliveryOrderList.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<RestaurantOrderOutputPayload>>(restaurantOutForDeliveryOrderList, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching out-for-delivery-order list for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Delivered Restaurant Order
    @RequestMapping(value = "/restaurant-delivered-order-list", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantOrderOutputPayload>> listAllDeliveredRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            List<RestaurantOrderOutputPayload> restaurantDeliveredOrderList = restaurantOrderService.getAllDeliveredOrderForARestaurant(restaurantTenantId);
            if (restaurantDeliveredOrderList.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<RestaurantOrderOutputPayload>>(restaurantDeliveredOrderList, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching delivered-order list for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Delivered Restaurant Order for a Given Date-Range
    @RequestMapping(value = "/restaurant-delivered-order-list-for-date-range", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantOrderOutputPayload>> listAllDeliveredRestaurantOrderForARestaurantForTheDateRange(@RequestParam("restaurant_tenant_id") String restaurantTenantId, @RequestParam("from_date") String fromDate, @RequestParam("to_date") String toDate) {
        try {
            List<RestaurantOrderOutputPayload> restaurantDeliveredOrderList = restaurantOrderService.getAllDeliveredOrderForARestaurant(restaurantTenantId, fromDate, toDate);
            if (restaurantDeliveredOrderList.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<RestaurantOrderOutputPayload>>(restaurantDeliveredOrderList, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching delivered-order list for restaurant:{} for date-range from:{} to :{}", e.getMessage(),
                restaurantTenantId, fromDate, toDate);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Cancelled Restaurant Order
    @RequestMapping(value = "/restaurant-cancelled-order-list", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantOrderOutputPayload>> listAllCancelledRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            List<RestaurantOrderOutputPayload> restaurantCancelledOrderList = restaurantOrderService.getAllCancelledOrderForARestaurant(restaurantTenantId);
            if (restaurantCancelledOrderList.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<RestaurantOrderOutputPayload>>(restaurantCancelledOrderList, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching cancelled-order list for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Cancelled Restaurant Order for a Given Date-Range
    @RequestMapping(value = "/restaurant-cancelled-order-list-for-date-range", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantOrderOutputPayload>> listAllCancelledRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId, @RequestParam("from_date") String fromDate, @RequestParam("to_date") String toDate) {
        try {
            List<RestaurantOrderOutputPayload> restaurantCancelledOrderList = restaurantOrderService.getAllCancelledOrderForARestaurant(restaurantTenantId, fromDate, toDate);
            if (restaurantCancelledOrderList.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<RestaurantOrderOutputPayload>>(restaurantCancelledOrderList, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching cancelled-order list for restaurant:{} for date-range from:{} to :{}", e.getMessage(),
                    restaurantTenantId, fromDate, toDate);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Queued Restaurant Order
    @RequestMapping(value = "/restaurant-queued-order-list", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantOrderOutputPayload>> listAllQueuedRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            List<RestaurantOrderOutputPayload> restaurantQueuedOrderList = restaurantOrderService.getAllQueuedOrderForARestaurant(restaurantTenantId);
            if (restaurantQueuedOrderList.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<RestaurantOrderOutputPayload>>(restaurantQueuedOrderList, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching queued-order list for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Accepted Restaurant Order Count
    @RequestMapping(value = "/restaurant-accepted-order-count", method = RequestMethod.GET)
    public ResponseEntity<String> countAllAcceptedRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            Long restaurantAcceptedOrderCount = restaurantOrderService.getAllAcceptedOrderCountForARestaurant(restaurantTenantId);
            if (restaurantAcceptedOrderCount == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<String>(restaurantAcceptedOrderCount.toString(), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching accepted-order count for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Food-In-Preparation Restaurant Order Count
    @RequestMapping(value = "/restaurant-food-in-preparation-order-count", method = RequestMethod.GET)
    public ResponseEntity<String> countAllFoodInPreparationRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            Long restaurantFoodInPreparationOrderCount = restaurantOrderService.getAllOrderInPreparationCountForARestaurant(restaurantTenantId);
            if (restaurantFoodInPreparationOrderCount == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<String>(restaurantFoodInPreparationOrderCount.toString(), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching food-in-preparation-order count for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Food-Ready Restaurant Order Count
    @RequestMapping(value = "/restaurant-food-ready-order-count", method = RequestMethod.GET)
    public ResponseEntity<String> countAllFoodReadyRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            Long restaurantFoodReadyOrderCount = restaurantOrderService.getAllFoodReadyOrderCountForARestaurant(restaurantTenantId);
            if (restaurantFoodReadyOrderCount == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<String>(restaurantFoodReadyOrderCount.toString(), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching food-ready-order count for restaurant:{}", e.getMessage(),
                restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Out-For-Delivery Restaurant Order Count
    @RequestMapping(value = "/restaurant-out-for-delivery-order-count", method = RequestMethod.GET)
    public ResponseEntity<String> countAllOutForDeliveryRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            Long restaurantOutForDeliveryOrderCount = restaurantOrderService.getAllOuForDeliveryOrderCountForARestaurant(restaurantTenantId);
        if (restaurantOutForDeliveryOrderCount == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You may decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<String>(restaurantOutForDeliveryOrderCount.toString(), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching out-for-delivery-order count for restaurant:{}", e.getMessage(),
                restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Delivered Restaurant Order Count
    @RequestMapping(value = "/restaurant-delivered-order-count", method = RequestMethod.GET)
    public ResponseEntity<String> countAllDeliveredRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            Long restaurantDeliveredOrderCount = restaurantOrderService.getAllDeliveredOrderCountForARestaurant(restaurantTenantId);
            if (restaurantDeliveredOrderCount == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<String>(restaurantDeliveredOrderCount.toString(), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching delivered-order count for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Cancelled Restaurant Order Count
    @RequestMapping(value = "/restaurant-cancelled-order-count", method = RequestMethod.GET)
    public ResponseEntity<String> countAllCancelledRestaurantOrderForARestaurant(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            Long restaurantCancelledOrderCount = restaurantOrderService.getCancelledOrderCountForARestaurant(restaurantTenantId);
            if (restaurantCancelledOrderCount == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<String>(restaurantCancelledOrderCount.toString(), HttpStatus.OK);
        }
       catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching restaurant-cancelled-order count for restaurant:{}", e.getMessage(),
                restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Highest Restaurant Order Today
    @RequestMapping(value = "/restaurant-highest-order-today", method = RequestMethod.GET)
    public ResponseEntity<String> getHighestRestaurantOrderForARestaurantToday(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            Double highestRestaurantOrderToday = restaurantOrderService.getHighestOrderForARestaurant(restaurantTenantId);
            if (highestRestaurantOrderToday == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<String>(highestRestaurantOrderToday.toString(), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching highest order of today for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Restaurant Revenue Today
    @RequestMapping(value = "/restaurant-revenue-today", method = RequestMethod.GET)
    public ResponseEntity<String> getRestaurantRevenueForARestaurantToday(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            Double restaurantOrderRevenueToday = restaurantOrderService.getRevenueForARestaurant(restaurantTenantId);
            if (restaurantOrderRevenueToday == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<String>(restaurantOrderRevenueToday.toString(), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching today's revenue for restaurant:{}", e.getMessage(),
                    restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Revenue this month
    @RequestMapping(value = "/restaurant-revenue-this-month", method = RequestMethod.GET)
    public ResponseEntity<String> getRestaurantRevenueForARestaurantThisMonth(@RequestParam("restaurant_tenant_id") String restaurantTenantId) {
        try {
            Double restaurantOrderRevenueThisMonth = restaurantOrderService.getRevenueThisMonthForARestaurant(restaurantTenantId);
            if (restaurantOrderRevenueThisMonth == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<String>(restaurantOrderRevenueThisMonth.toString(), HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching this month's revenue for restaurant:{}", e.getMessage(),
                restaurantTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Invoice For Restaurant Order
    @RequestMapping(value = "/order-invoice", method = RequestMethod.GET)
    public ResponseEntity<OrderInvoice> generateInvoiceForARestaurantOrderForARestaurant(@RequestParam("restaurant_order_id") String restaurantOrderId) {
        try {
            OrderInvoice orderInvoice = invoiceGenerationService.generateInvoice(Integer.parseInt(restaurantOrderId));
            if (orderInvoice == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You may decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<OrderInvoice>(orderInvoice, HttpStatus.OK);
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching invoice for order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Outlet-Tenant Details for a Master-Tenant
    @RequestMapping(value = "/restaurant-tenant-details", method = RequestMethod.GET)
    public ResponseEntity<RestaurantTenantDetails> getOutletTenantDetailsForAMasterRestaurantTenant(@RequestParam("restaurant_master_tenant_id") String restaurantMasterTenantId) {
        try {
            if (restaurantMasterTenantId == null | restaurantMasterTenantId.isEmpty()) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else {
                RestaurantTenantDetails restaurantTenantDetails = restaurantOrchestratorService.getOutletDetailsForMasterTenant(restaurantMasterTenantId);
                if (restaurantTenantDetails == null) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
                else {
                    return new ResponseEntity<RestaurantTenantDetails>(restaurantTenantDetails, HttpStatus.OK);
                }
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching outlet-tenant details for restaurant:{}", e.getMessage(),
                    restaurantMasterTenantId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Order-Details Using OrderId
    @RequestMapping(value = "/order-details", method = RequestMethod.GET)
    public ResponseEntity<RestaurantOrderOutputPayload> getOrderDetails(@RequestParam("restaurant_order_id") String restaurantOrderId) {
        try {
            if (restaurantOrderId == null || restaurantOrderId.isEmpty()) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else {
                RestaurantOrder restaurantOrder = restaurantOrderService.getOrderDetailsForOrderId(restaurantOrderId);
                if (restaurantOrder == null) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
                else {
                    List<Item> orderedItemList = null;
                    orderedItemList = cartService.getItemListOfACart(restaurantOrder.getCartId().toString(), 0);
                    if (orderedItemList.isEmpty() || orderedItemList == null) {
                        return new ResponseEntity<RestaurantOrderOutputPayload>(
                                new RestaurantOrderOutputPayload(restaurantOrder, null),
                                HttpStatus.OK);
                    }
                    else {
                        return new ResponseEntity<RestaurantOrderOutputPayload>(
                                new RestaurantOrderOutputPayload(restaurantOrder, orderedItemList),
                                HttpStatus.OK);
                    }
                }
            }
        }
        catch (Exception e) {
            LOGGER.error("Exception:{} occurred while fetching order-details for order:{}", e.getMessage(),
                    restaurantOrderId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean checkWhetherRestaurantLoggedIn(String s) {
        int retry = 0;
        while (retry <= CACHE_INGESTION_MAX_RETRY_COUNT) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String url = "http://13.233.89.218:8084/api/cache/login/status" + s;
            LOGGER.info("url: {}", url);
            ResponseEntity<RestaurantLoginStatus> restaurantLoginStatus = restTemplate.getForEntity(url, RestaurantLoginStatus.class);
            if (restaurantLoginStatus.getBody() == null) {
                return false;
            } else if (restaurantLoginStatus.getBody().getRestaurantUserLoginStatus() == 1) {
                return true;
            }
        }
        return false;
    }


}
