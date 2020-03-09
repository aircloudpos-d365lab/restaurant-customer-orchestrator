package com.d365lab.eatery.restaurantcustomerorchestrator.repositories;

import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantInfo;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantTenantDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Integer> {

    @Query(value = "SELECT ri FROM restaurant_info ri WHERE restaurant_outlet_tenant_id = :restaurantOutletTenantId", nativeQuery = true)
    RestaurantInfo findRestaurantInfoForRestaurant(@Param("restaurantOutletTenantId") String restaurantOutletTenantId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurant_info SET restaurant_email = :restaurantEmailId WHERE restaurant_outlet_tenant_id = :restaurantOutletTenantId")
    void updateRestaurantEmailInfoForRestaurant(@Param("restaurantOutletTenantId") String restaurantOutletTenantId, @Param("restaurantEmailId") String restaurantEmailId);

    @Query(value = "Select * from restaurant_info ri WHERE restaurant_master_tenant_id = :restaurantMasterTenantId", nativeQuery = true)
    List<RestaurantInfo> findTenantsOfARestaurant(String restaurantMasterTenantId);
}
