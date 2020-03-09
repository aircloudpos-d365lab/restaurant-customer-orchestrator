package com.d365lab.eatery.restaurantcustomerorchestrator.services;

import com.d365lab.eatery.restaurantcustomerorchestrator.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    List<Item> getItemListOfACart(String cartId, Integer retryCount);
}
