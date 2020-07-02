/*
 * This file was automatically generated by EvoSuite
 * Mon Mar 09 09:06:29 GMT 2020
 */

package com.d365lab.eatery.restaurantcustomerorchestrator.controllers;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.controllers.RestaurantOnboardingController;
import com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantLogin;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantLoginPayload;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOnboardingService;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class RestaurantOnboardingController_ESTest extends RestaurantOnboardingController_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      RestaurantOnboardingController restaurantOnboardingController0 = new RestaurantOnboardingController();
      RestaurantOnboardingService restaurantOnboardingService0 = mock(RestaurantOnboardingService.class, new ViolatedAssumptionAnswer());
      doReturn((List<RestaurantLogin>) null).when(restaurantOnboardingService0).verifyPassword(anyString() , anyString());
      Injector.inject(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class, "restaurantOnboardingService", (Object) restaurantOnboardingService0);
      Injector.validateBean(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class);
      RestaurantLoginPayload restaurantLoginPayload0 = mock(RestaurantLoginPayload.class, new ViolatedAssumptionAnswer());
      doReturn("").when(restaurantLoginPayload0).getRestaurantPassword();
      doReturn("").when(restaurantLoginPayload0).getRestaurantUsername();
      ResponseEntity<List<RestaurantLogin>> responseEntity0 = restaurantOnboardingController0.verifyLoginOfARestaurant(restaurantLoginPayload0);
      assertFalse(responseEntity0.hasBody());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      RestaurantOnboardingController restaurantOnboardingController0 = new RestaurantOnboardingController();
      RestaurantOnboardingService restaurantOnboardingService0 = mock(RestaurantOnboardingService.class, new ViolatedAssumptionAnswer());
      doReturn((List<RestaurantLogin>) null).when(restaurantOnboardingService0).logoutRestaurant(anyString());
      Injector.inject(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class, "restaurantOnboardingService", (Object) restaurantOnboardingService0);
      Injector.validateBean(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class);
      RestaurantLoginPayload restaurantLoginPayload0 = mock(RestaurantLoginPayload.class, new ViolatedAssumptionAnswer());
      doReturn("Q=<VTu,G").when(restaurantLoginPayload0).getRestaurantUsername();
      ResponseEntity<List<RestaurantLogin>> responseEntity0 = restaurantOnboardingController0.logoutARestaurant(restaurantLoginPayload0);
      assertEquals(200, responseEntity0.getStatusCodeValue());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      RestaurantOnboardingController restaurantOnboardingController0 = new RestaurantOnboardingController();
      RestaurantOnboardingService restaurantOnboardingService0 = mock(RestaurantOnboardingService.class, new ViolatedAssumptionAnswer());
      doReturn((List) null).when(restaurantOnboardingService0).logoutRestaurant(anyString());
      Injector.inject(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class, "restaurantOnboardingService", (Object) restaurantOnboardingService0);
      Injector.validateBean(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class);
      RestaurantLoginPayload restaurantLoginPayload0 = new RestaurantLoginPayload();
      ResponseEntity<List<RestaurantLogin>> responseEntity0 = (ResponseEntity<List<RestaurantLogin>>)restaurantOnboardingController0.logoutARestaurant(restaurantLoginPayload0);
      assertEquals(200, responseEntity0.getStatusCodeValue());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      RestaurantOnboardingController restaurantOnboardingController0 = new RestaurantOnboardingController();
      RestaurantOnboardingService restaurantOnboardingService0 = mock(RestaurantOnboardingService.class, new ViolatedAssumptionAnswer());
      Injector.inject(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class, "restaurantOnboardingService", (Object) restaurantOnboardingService0);
      Injector.validateBean(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class);
      // Undeclared exception!
      try { 
        restaurantOnboardingController0.verifyLoginOfARestaurant((RestaurantLoginPayload) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.controllers.RestaurantOnboardingController", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      RestaurantOnboardingController restaurantOnboardingController0 = new RestaurantOnboardingController();
      RestaurantOnboardingService restaurantOnboardingService0 = mock(RestaurantOnboardingService.class, new ViolatedAssumptionAnswer());
      doReturn((List) null).when(restaurantOnboardingService0).verifyPassword(anyString() , anyString());
      Injector.inject(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class, "restaurantOnboardingService", (Object) restaurantOnboardingService0);
      Injector.validateBean(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class);
      RestaurantLoginPayload restaurantLoginPayload0 = new RestaurantLoginPayload();
      ResponseEntity<List<RestaurantLogin>> responseEntity0 = (ResponseEntity<List<RestaurantLogin>>)restaurantOnboardingController0.verifyLoginOfARestaurant(restaurantLoginPayload0);
      assertEquals(200, responseEntity0.getStatusCodeValue());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      RestaurantOnboardingController restaurantOnboardingController0 = new RestaurantOnboardingController();
      RestaurantOnboardingService restaurantOnboardingService0 = mock(RestaurantOnboardingService.class, new ViolatedAssumptionAnswer());
      Injector.inject(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class, "restaurantOnboardingService", (Object) restaurantOnboardingService0);
      Injector.validateBean(restaurantOnboardingController0, (Class<?>) RestaurantOnboardingController.class);
      // Undeclared exception!
      try { 
        restaurantOnboardingController0.logoutARestaurant((RestaurantLoginPayload) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.controllers.RestaurantOnboardingController", e);
      }
  }
}