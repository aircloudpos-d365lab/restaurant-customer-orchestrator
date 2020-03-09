package com.d365lab.eatery.restaurantcustomerorchestrator.services;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenuCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantMenuCategoryService {

    List<RestaurantMenuCategory> getAllMenuCategoryList();
}
