package com.d365lab.eatery.restaurantcustomerorchestrator.repositories;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {

//    @Query(value = "SELECT rm FROM restaurant_menu rm WHERE restaurant_outlet_tenant_id = :restaurantTenantId GROUP BY restaurant_menu_category ORDER BY restaurant_menu_name")
//    Page<RestaurantMenu> findAllMenusForRestaurantWithPagination(@Param("restaurantTenantId") String restaurantTenantId, Pageable paging);

    @Query(value = "SELECT rm FROM restaurant_menu rm WHERE restaurant_outlet_tenant_id = :restaurantTenantId GROUP BY restaurant_menu_category ORDER BY restaurant_menu_name")
    List<RestaurantMenu> findAllMenusForRestaurant(@Param("restaurantTenantId") String restaurantTenantId);

    @Query(value = "SELECT rm FROM restaurant_menu rm WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND restaurant_menu_name = :restaurantMenuName")
    RestaurantMenu findMenuOfARestaurant(@Param("restaurantMenuName") String restaurantMenuName, @Param("restaurantTenantId") String restaurantTenantId);

    @Query(value = "SELECT rm FROM restaurant_menu rm WHERE restaurant_outlet_tenant_id = :restaurantTenantId AND restaurant_menu_id = :restaurantMenuId")
    RestaurantMenu findMenuOfARestaurantThroughId(@Param("restaurantMenuId") Integer restaurantMenuId, @Param("restaurantTenantId") String restaurantTenantId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_menu SET restaurant_menu_photo_url = :restaurantMenuPhotoUrl WHERE restaurant_menu_id = :restaurantMenuId")
    void updateMenuPhotoUrlForMenuForARestaurant(@Param("restaurantMenuPhotoUrl") String restaurantMenuPhotoUrl, @Param("restaurantMenuId") Integer restaurantMenuId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_menu SET restaurant_outlet_tenant_id = :restaurantTenantId, restaurant_menu_name = :restaurantMenuName, restaurant_menu_description = :restaurantMenuDescription, restaurant_menu_type = :restaurantMenuType, restaurant_menu_price = :restaurantMenuPrice, restaurant_menu_category = :restaurantMenuCategory, restaurant_menu_photo_url = :restaurantMenuPhoto, restaurant_menu_price_cgst_percentage = :restaurantMenuPriceCgstPercentage, restaurant_menu_price_sgst_percentage = :restaurantMenuPriceSgstPercentage, restaurant_menu_final_price = :restaurantMenuFinalPrice WHERE restaurant_menu_id = :restaurantMenuId", nativeQuery = true)
    void updateMenuOfARestaurant(Integer restaurantMenuId, String restaurantTenantId, String restaurantMenuName, String restaurantMenuDescription, String restaurantMenuType, Double restaurantMenuPrice, String restaurantMenuCategory, String restaurantMenuPhoto, Double restaurantMenuPriceCgstPercentage, Double restaurantMenuPriceSgstPercentage, Double restaurantMenuFinalPrice);

    @Query(value = "SELECT rm FROM restaurant_menu rm WHERE restaurant_menu_id = :restaurantMenuId")
    RestaurantMenu findByMenuId(Integer restaurantMenuId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_menu SET is_menu_disabled = 0 WHERE restaurant_menu_id = :restaurantMenuId", nativeQuery = true)
    void resetToEnableMenu(String restaurantMenuId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_menu SET is_menu_disabled = 1 WHERE restaurant_menu_id = :restaurantMenuId", nativeQuery = true)
    void setToDisableMenu(String restaurantMenuId);
}
