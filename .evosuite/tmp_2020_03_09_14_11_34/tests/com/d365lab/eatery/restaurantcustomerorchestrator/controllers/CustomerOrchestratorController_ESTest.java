/*
 * This file was automatically generated by EvoSuite
 * Mon Mar 09 08:55:36 GMT 2020
 */

package com.d365lab.eatery.restaurantcustomerorchestrator.controllers;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.controllers.CustomerOrchestratorController;
import com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.CustomerAddress;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantCustomerMap;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.CustomerOrchestratorService;
import java.util.List;
import java.util.Stack;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CustomerOrchestratorController_ESTest extends CustomerOrchestratorController_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerInfo customerInfo0 = new CustomerInfo();
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      doReturn(customerInfo0).when(customerOrchestratorService0).addCustomerInfo(any(com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo.class));
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      Integer integer0 = new Integer(0);
      CustomerInfo customerInfo1 = new CustomerInfo(integer0, (String) null, (String) null, "", "@J", "", "Customer-Info is Updated Successfully!", "Customer-Info is Updated Successfully!", "");
      ResponseEntity<CustomerInfo> responseEntity0 = customerOrchestratorController0.createCustomerInfoForARestaurant(customerInfo1);
      assertTrue(responseEntity0.hasBody());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      CustomerAddress customerAddress0 = new CustomerAddress();
      ResponseEntity<String> responseEntity0 = customerOrchestratorController0.updateCustomerAddress(customerAddress0);
      assertTrue(responseEntity0.hasBody());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      doReturn((List<CustomerInfo>) null).when(customerOrchestratorService0).getCustomersForRestaurant(anyString());
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      // Undeclared exception!
      try { 
        customerOrchestratorController0.getCustomerListForARestaurant("");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerInfo customerInfo0 = null;
      Stack<CustomerInfo> stack0 = new Stack<CustomerInfo>();
      // Undeclared exception!
      try { 
        customerOrchestratorController0.getCustomerDetails("{)h$&H+[E");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.controllers.CustomerOrchestratorController", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerInfo customerInfo0 = new CustomerInfo();
      Stack<CustomerInfo> stack0 = new Stack<CustomerInfo>();
      // Undeclared exception!
      try { 
        customerOrchestratorController0.createCustomerInfoForARestaurant(customerInfo0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.controllers.CustomerOrchestratorController", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      Stack<CustomerInfo> stack0 = new Stack<CustomerInfo>();
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(customerOrchestratorService0).getCustomersForRestaurant(anyString());
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      ResponseEntity<RestaurantCustomerMap> responseEntity0 = customerOrchestratorController0.getCustomerListForARestaurant("{rO.pAGpUN1!m%#TR9");
      assertFalse(responseEntity0.hasBody());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerInfo customerInfo0 = new CustomerInfo();
      Stack<CustomerInfo> stack0 = new Stack<CustomerInfo>();
      stack0.add(customerInfo0);
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(customerOrchestratorService0).getCustomersForRestaurant(anyString());
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      ResponseEntity<RestaurantCustomerMap> responseEntity0 = customerOrchestratorController0.getCustomerListForARestaurant("o");
      assertEquals(200, responseEntity0.getStatusCodeValue());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      doReturn((CustomerInfo) null).when(customerOrchestratorService0).getCustomerDetails(anyString());
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      ResponseEntity<CustomerInfo> responseEntity0 = customerOrchestratorController0.getCustomerDetails("{rO.pAGpUN1!m%#TR9");
      assertEquals(204, responseEntity0.getStatusCodeValue());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerInfo customerInfo0 = new CustomerInfo();
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      doReturn(customerInfo0).when(customerOrchestratorService0).getCustomerDetails(anyString());
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      ResponseEntity<CustomerInfo> responseEntity0 = customerOrchestratorController0.getCustomerDetails("o");
      assertEquals(200, responseEntity0.getStatusCodeValue());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      doReturn((CustomerInfo) null).when(customerOrchestratorService0).addCustomerInfo(any(com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo.class));
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      ResponseEntity<CustomerInfo> responseEntity0 = customerOrchestratorController0.createCustomerInfoForARestaurant((CustomerInfo) null);
      assertEquals(500, responseEntity0.getStatusCodeValue());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      // Undeclared exception!
      try { 
        customerOrchestratorController0.updateCustomerAddress((CustomerAddress) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.controllers.CustomerOrchestratorController", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      CustomerOrchestratorController customerOrchestratorController0 = new CustomerOrchestratorController();
      CustomerInfo customerInfo0 = new CustomerInfo();
      CustomerOrchestratorService customerOrchestratorService0 = mock(CustomerOrchestratorService.class, new ViolatedAssumptionAnswer());
      Injector.inject(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class, "customerOrchestratorService", (Object) customerOrchestratorService0);
      Injector.validateBean(customerOrchestratorController0, (Class<?>) CustomerOrchestratorController.class);
      ResponseEntity<String> responseEntity0 = customerOrchestratorController0.updateCustomerInfo(customerInfo0);
      assertEquals(200, responseEntity0.getStatusCodeValue());
  }
}
