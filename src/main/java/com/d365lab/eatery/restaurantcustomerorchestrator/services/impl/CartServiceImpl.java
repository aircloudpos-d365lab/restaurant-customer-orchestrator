package com.d365lab.eatery.restaurantcustomerorchestrator.services.impl;

import com.d365lab.eatery.restaurantcustomerorchestrator.model.Cart;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.Item;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CartServiceImpl.class);

    private static final Integer HTTP_MAX_RETRIES = 3;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Item> getItemListOfACart(String cartId, Integer retryCount) {

        String url = "http://13.233.131.195:8083/api/customer-cart?cart_id="+cartId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(cartId, headers);
        ResponseEntity<Cart> response = restTemplate.getForEntity(url, Cart.class);
        while (response.getBody() == null &&
                response.getStatusCode() != HttpStatus.OK &&
                retryCount < HTTP_MAX_RETRIES) {
            response = restTemplate.getForEntity(url, Cart.class);
            retryCount++;
        }
        return response.getBody() == null ? null : response.getBody().getCartMenuList();
    }
}
