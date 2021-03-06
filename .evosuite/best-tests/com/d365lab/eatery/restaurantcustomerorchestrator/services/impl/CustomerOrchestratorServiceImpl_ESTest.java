/*
 * This file was automatically generated by EvoSuite
 * Mon Mar 09 08:59:41 GMT 2020
 */

package com.d365lab.eatery.restaurantcustomerorchestrator.services.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo;
import com.d365lab.eatery.restaurantcustomerorchestrator.repositories.CustomerInfoRepository;
import com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.CustomerOrchestratorServiceImpl;
import java.util.List;
import java.util.Stack;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CustomerOrchestratorServiceImpl_ESTest extends CustomerOrchestratorServiceImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      CustomerInfo customerInfo0 = mock(CustomerInfo.class, new ViolatedAssumptionAnswer());
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn(customerInfo0).when(customerInfoRepository0).findCustomerInfoForRestaurant(anyString());
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      Integer integer0 = new Integer(2525);
      CustomerInfo customerInfo1 = new CustomerInfo(integer0, "4*;L~IKumE(q&69OA", "E}&H5CQB7 '", "E}&H5CQB7 '", "E}&H5CQB7 '", "4", (String) null, "", "bwF9$we");
      try { 
        customerOrchestratorServiceImpl0.addCustomerInfo(customerInfo1);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Customer Info is already present for customer with tenant-id:4*;L~IKumE(q&69OA
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.CustomerOrchestratorServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn((List) null).when(customerInfoRepository0).findCustomersForRestaurant(anyString());
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      List<CustomerInfo> list0 = customerOrchestratorServiceImpl0.getCustomersForRestaurant("L\"qCAV");
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      Stack<CustomerInfo> stack0 = new Stack<CustomerInfo>();
      CustomerInfo customerInfo0 = new CustomerInfo((Integer) null, "CvrEq>Uab", "", "%s-%s", "_c@E0,joM,6kcp", (String) null, "xP~4", "CvrEq>Uab", (String) null);
      stack0.add(customerInfo0);
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(customerInfoRepository0).findCustomersForRestaurant(anyString());
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      List<CustomerInfo> list0 = customerOrchestratorServiceImpl0.getCustomersForRestaurant("eJ`T?t<>S3\bGQq&");
      assertTrue(list0.contains(customerInfo0));
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      CustomerInfo customerInfo0 = new CustomerInfo((Integer) null, "C.AnF", "Customer Info is already present for customer with tenant-id:", "C.AnF", "C.AnF", "Customer Info is already present for customer with tenant-id:", "Customer Info is already present for customer with tenant-id:", "X`,JvBs", "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.CustomerOrchestratorServiceImpl");
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn(customerInfo0).when(customerInfoRepository0).findCustomerInfoForRestaurant(anyString());
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      CustomerInfo customerInfo1 = customerOrchestratorServiceImpl0.getCustomerDetails((String) null);
      assertNull(customerInfo1);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      CustomerInfo customerInfo0 = new CustomerInfo((Integer) null, "C.AnF", "Customer Info is already present for customer with tenant-id:", "C.AnF", "C.AnF", "Customer Info is already present for customer with tenant-id:", "Customer Info is already present for customer with tenant-id:", "X`,JvBs", "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.CustomerOrchestratorServiceImpl");
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn(customerInfo0).when(customerInfoRepository0).findCustomerInfoForRestaurant(anyString());
      doReturn(customerInfo0).when(customerInfoRepository0).save(nullable(java.lang.Object.class));
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      CustomerInfo customerInfo1 = new CustomerInfo();
      CustomerInfo customerInfo2 = customerOrchestratorServiceImpl0.addCustomerInfo(customerInfo1);
      assertEquals("Customer Info is already present for customer with tenant-id:", customerInfo2.getCustomerEmail());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      CustomerInfo customerInfo0 = mock(CustomerInfo.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(customerInfo0).getCustomerTenantId();
      doReturn((String) null).when(customerInfo0).toString();
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn(customerInfo0, customerInfo0).when(customerInfoRepository0).findCustomerInfoForRestaurant(anyString());
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      CustomerInfo customerInfo1 = customerOrchestratorServiceImpl0.getCustomerDetails("eJ`T?t<>S3\bGQq&");
      // Undeclared exception!
      try { 
        customerOrchestratorServiceImpl0.updateCustomerInfo(customerInfo1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.CustomerOrchestratorServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      // Undeclared exception!
      try { 
        customerOrchestratorServiceImpl0.updateCustomerAddress("", "", "", (String) null, "");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.CustomerOrchestratorServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      // Undeclared exception!
      try { 
        customerOrchestratorServiceImpl0.getCustomersForRestaurant("");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.CustomerOrchestratorServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      // Undeclared exception!
      try { 
        customerOrchestratorServiceImpl0.getCustomerDetails("$Mw>Mv5jb%[7mu{^");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.CustomerOrchestratorServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      // Undeclared exception!
      try { 
        customerOrchestratorServiceImpl0.addCustomerInfo((CustomerInfo) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.CustomerOrchestratorServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      Integer integer0 = new Integer(0);
      CustomerInfo customerInfo0 = new CustomerInfo(integer0, "", "keyFunction is marked non-null but is null", "", "", "ANY", "", "__revisionNumber__", "Rm'|;nt0k9]kzw");
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn(customerInfo0).when(customerInfoRepository0).findCustomerInfoForRestaurant(anyString());
      doReturn("").when(customerInfoRepository0).save(nullable(java.lang.Object.class));
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      CustomerInfo customerInfo1 = new CustomerInfo();
      // Undeclared exception!
      try { 
        customerOrchestratorServiceImpl0.addCustomerInfo(customerInfo1);
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.String cannot be cast to com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.repositories.CustomerInfoRepository$MockitoMock$913811426", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn((CustomerInfo) null).when(customerInfoRepository0).findCustomerInfoForRestaurant(anyString());
      doReturn((Object) null).when(customerInfoRepository0).save(nullable(java.lang.Object.class));
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      CustomerInfo customerInfo0 = new CustomerInfo();
      CustomerInfo customerInfo1 = customerOrchestratorServiceImpl0.addCustomerInfo(customerInfo0);
      assertNull(customerInfo1);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      customerOrchestratorServiceImpl0.updateCustomerAddress("Customer Info is already present for customer with tenant-id:", "", "Customer Info is already present for customer with tenant-id:", (String) null, "4}");
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      Stack<CustomerInfo> stack0 = new Stack<CustomerInfo>();
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(customerInfoRepository0).findCustomersForRestaurant(anyString());
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      List<CustomerInfo> list0 = customerOrchestratorServiceImpl0.getCustomersForRestaurant("eJ`T?t<>S3\bGQq&");
      assertTrue(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      CustomerOrchestratorServiceImpl customerOrchestratorServiceImpl0 = new CustomerOrchestratorServiceImpl();
      CustomerInfo customerInfo0 = mock(CustomerInfo.class, new ViolatedAssumptionAnswer());
      doReturn((Integer) null).when(customerInfo0).getCustomerId();
      CustomerInfo customerInfo1 = new CustomerInfo((Integer) null, "CvrEq>Uab", "", "%s-%s", "_c@E0,joM,6kcp", (String) null, "xP~4", "CvrEq>Uab", (String) null);
      CustomerInfoRepository customerInfoRepository0 = mock(CustomerInfoRepository.class, new ViolatedAssumptionAnswer());
      doReturn(customerInfo0).when(customerInfoRepository0).findCustomerInfoForRestaurant(anyString());
      Injector.inject(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class, "customerInfoRepository", (Object) customerInfoRepository0);
      Injector.validateBean(customerOrchestratorServiceImpl0, (Class<?>) CustomerOrchestratorServiceImpl.class);
      customerOrchestratorServiceImpl0.updateCustomerInfo(customerInfo1);
      assertEquals("_c@E0,joM,6kcp", customerInfo1.getCustomerName());
  }
}
