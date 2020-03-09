package com.d365lab.eatery.restaurantcustomerorchestrator.repositories;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantLogin;
import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface RestaurantLoginRepository extends JpaRepository<RestaurantLogin, Long> {

    @Query(value = "SELECT * FROM restaurant_login WHERE restaurant_username = :restaurantUserName", nativeQuery = true)
    List<RestaurantLogin> findRestaurantLoginForARestaurant(@Param("restaurantUserName") String restaurantUserName);

    @Query(value = "SELECT * FROM restaurant_login WHERE restaurant_master_tenant_id = :restaurantMasterTenantId", nativeQuery = true)
    List<RestaurantLogin> findRestaurantLoginForAGivenMasterTenantId(@Param("restaurantMasterTenantId") String restaurantMasterTenantId);

    @Query(value = "SELECT * FROM restaurant_login WHERE restaurant_brand_name = :restaurantBrandName", nativeQuery = true)
    List<RestaurantLogin> findTenantsForARestaurantBrand(@Param("restaurantBrandName") String restaurantBrandName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_login SET restaurant_salt = :restaurantSalt, restaurant_encrypted_password = :restaurantEncryptedPassword WHERE restaurant_login_id = :restaurantLoginId AND restaurant_username = :restaurantUserName", nativeQuery = true)
    void updateLoginForRestaurant(Integer restaurantLoginId, String restaurantUserName, String restaurantSalt, String restaurantEncryptedPassword);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_login SET is_logged_in = 1 AND last_logged_in_at = :loginTimestamp WHERE restaurant_login_id = :restaurantLoginId", nativeQuery = true)
    void updateLoggedInFlagAndLoggedInTimestampForRestaurant(Integer restaurantLoginId, Date loginTimestamp);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_login SET is_logged_in = 0 WHERE restaurant_login_id = :restaurantLoginId", nativeQuery = true)
    void updateLoggedOutForRestaurant(Integer restaurantLoginId);

    @Query(value = "SELECT * FROM restaurant_login WHERE restaurant_username = :userName AND is_logged_in = 1", nativeQuery = true)
    List<RestaurantLogin> findLoggedInRestaurant(String userName);
}
