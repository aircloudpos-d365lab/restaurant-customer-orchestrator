package com.d365lab.eatery.restaurantcustomerorchestrator.services.impl;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenuCategory;
import com.d365lab.eatery.restaurantcustomerorchestrator.repositories.RestaurantMenuCategoryRepository;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantMenuCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantMenuCategoryServiceImpl implements RestaurantMenuCategoryService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantMenuCategoryServiceImpl.class);

    @Autowired
    private RestaurantMenuCategoryRepository restaurantMenuCategoryRepository;

    @Override
    public List<RestaurantMenuCategory> getAllMenuCategoryList() {
        return restaurantMenuCategoryRepository.findRestaurantMenuCategories();
    }
}
