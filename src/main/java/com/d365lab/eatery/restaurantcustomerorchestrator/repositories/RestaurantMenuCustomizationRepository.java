package com.d365lab.eatery.restaurantcustomerorchestrator.repositories;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenuCustomization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RestaurantMenuCustomizationRepository extends JpaRepository<RestaurantMenuCustomization, Long> {

    @Query(value = "SELECT rmc FROM restaurant_menu_customization rmc WHERE restaurant_tenant_id = :restaurantTenantId ORDER BY restaurant_menu_customization_id")
    List<RestaurantMenuCustomization> findAllMenuCustomizationsForRestaurant(@Param("restaurantTenantId") Integer restaurantTenantId);

    @Query(value = "SELECT rmc FROM restaurant_menu_customization rmc WHERE restaurant_tenant_id = :restaurantTenantId AND restaurant_menu_id = :restaurantMenuId ORDER BY restaurant_menu_customization_id")
    List<RestaurantMenuCustomization> findMenuCustomizationsForAMenuForARestaurant(@Param("restaurantTenantId") String restaurantTenantId, @Param("restaurantMenuId") Integer restaurantMenuId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_menu_customization SET restaurant_menu_id = :restaurantMenuId, restaurant_tenant_id = :restaurantTenantId, restaurant_menu_customization_description = :customization  WHERE restaurant_menu_customization_id = :restaurantMenuCustomizationId", nativeQuery = true)
    void updateMenuCustomization(Integer restaurantMenuCustomizationId, Integer restaurantMenuId, String restaurantTenantId, String customization);

    @Query(value = "SELECT restaurant_menu_customization_id FROM restaurant_menu_customization WHERE restaurant_tenant_id = :restaurantTenantId AND restaurant_menu_id = :restaurantMenuId AND restaurant_menu_customization_description = :restaurantMenuCustomizationDescription", nativeQuery = true)
    Integer findMenuCustomizationIdForAMenuForARestaurant(Integer restaurantMenuId, String restaurantTenantId, String restaurantMenuCustomizationDescription);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM restaurant_menu_customization WHERE restaurant_tenant_id = :restaurantTenantId AND restaurant_menu_id = :restaurantMenuId", nativeQuery = true)
    void deleteExistingMenuCustomizationForAMenuForARestaurant(Integer restaurantMenuId, String restaurantTenantId);


}
