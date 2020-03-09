package com.d365lab.eatery.restaurantcustomerorchestrator.repositories;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantMenuCategoryRepository extends JpaRepository<RestaurantMenuCategory, Integer> {

    @Query(value = "SELECT * FROM restaurant_menu_category", nativeQuery = true)
    List<RestaurantMenuCategory> findRestaurantMenuCategories();

}
