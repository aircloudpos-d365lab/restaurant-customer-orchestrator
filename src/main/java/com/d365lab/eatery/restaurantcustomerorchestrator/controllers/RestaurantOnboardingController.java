package com.d365lab.eatery.restaurantcustomerorchestrator.controllers;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantLogin;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantLoginPayload;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOnboardingService;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.RestaurantCustomerOrchestratorException;
import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
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
public class RestaurantOnboardingController {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantOnboardingController.class);
    private static final Gson gson = new Gson();

    @Autowired
    private RestaurantOnboardingService restaurantOnboardingService;

    // create login for restaurant
//    @PostMapping(value = "/restaurant-login/add", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<String> createRestaurantLoginOfARestaurant(@RequestBody RestaurantLoginPayload restaurantLoginPayload) throws RestaurantCustomerOrchestratorException, ParseException {
//        String response = restaurantOnboardingService.generateLogin(restaurantLoginPayload.getRestaurantUsername(), restaurantLoginPayload.getRestaurantPassword());
//        if (response == null) {
//            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<String>(response, HttpStatus.OK);
//    }

    // Verify Login For a restaurant
    @PostMapping(value = "/restaurant-login/verify", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<RestaurantLogin>> verifyLoginOfARestaurant(@RequestBody RestaurantLoginPayload restaurantLoginPayload) throws RestaurantCustomerOrchestratorException, ParseException {
        List<RestaurantLogin> loginResponseList = restaurantOnboardingService.verifyPassword(restaurantLoginPayload.getRestaurantUsername(), restaurantLoginPayload.getRestaurantPassword());
        return new ResponseEntity<List<RestaurantLogin>>(loginResponseList, HttpStatus.OK);

    }

    // Logout For a restaurant
    @PostMapping(value = "/restaurant-logout", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<RestaurantLogin>> logoutARestaurant(@RequestBody RestaurantLoginPayload restaurantLoginPayload) throws RestaurantCustomerOrchestratorException, ParseException {
        List<RestaurantLogin> logoutResponseList = restaurantOnboardingService.logoutRestaurant(restaurantLoginPayload.getRestaurantUsername());
        return new ResponseEntity<List<RestaurantLogin>>(logoutResponseList, HttpStatus.OK);

    }
}
