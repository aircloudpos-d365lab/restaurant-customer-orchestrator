/*
 * This file was automatically generated by EvoSuite
 * Mon Mar 09 09:01:45 GMT 2020
 */

package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import org.junit.Test;
import static org.junit.Assert.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.Cart;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.Item;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Cart_ESTest extends Cart_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Cart cart0 = new Cart();
      MockDate mockDate0 = new MockDate(1796L);
      cart0.setUpdatedAt(mockDate0);
      cart0.getUpdatedAt();
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Cart cart0 = new Cart();
      cart0.setRestaurantTenantId("");
      cart0.getRestaurantTenantId();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Double double0 = new Double(1.0);
      Cart cart0 = new Cart("com.d365lab.eatery.restaurantcustomerorchestrator.model.Cart", (String) null, (List<Item>) null, integer0, (String) null, double0, double0, double0, double0, double0, double0, double0);
      cart0.getIsOrderPlaced();
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Integer integer0 = new Integer(2819);
      Double double0 = new Double(2819);
      Cart cart0 = new Cart("", "", (List<Item>) null, integer0, "com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", double0, double0, double0, double0, double0, double0, double0);
      cart0.getIsOrderPlaced();
      assertEquals("com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", cart0.getCouponAppliedOnCart());
      assertEquals("", cart0.getRestaurantTenantId());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Integer integer0 = new Integer((-1));
      Double double0 = new Double(0.0);
      Cart cart0 = new Cart("", "", (List<Item>) null, integer0, "", double0, double0, double0, double0, (Double) null, (Double) null, double0);
      Integer integer1 = cart0.getIsOrderPlaced();
      assertEquals((-1), (int)integer1);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Integer integer0 = new Integer(902);
      Double double0 = new Double(902);
      Cart cart0 = new Cart("com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", "", (List<Item>) null, integer0, "Db3h_2sej2%.", double0, double0, double0, double0, double0, double0, double0);
      String string0 = cart0.getCustomerTenantId();
      assertEquals("", string0);
      assertEquals("Db3h_2sej2%.", cart0.getCouponAppliedOnCart());
      assertEquals("com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", cart0.getRestaurantTenantId());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Stack<Item> stack0 = new Stack<Item>();
      Integer integer0 = new Integer(0);
      Double double0 = new Double(0);
      Cart cart0 = new Cart("com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", "com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", stack0, integer0, "com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", double0, double0, double0, double0, double0, double0, double0);
      MockDate mockDate0 = new MockDate(0, 0, 0, 0, 0);
      cart0.setCreatedAt(mockDate0);
      Date date0 = cart0.getCreatedAt();
      assertEquals("Sun Dec 31 00:00:00 GMT 1899", date0.toString());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Integer integer0 = new Integer((-1761));
      Double double0 = new Double((-1448.901));
      Cart cart0 = new Cart("", ", cartDiscountTotal=", (List<Item>) null, integer0, "AgB.sG6Y\"+h,pM", (Double) null, double0, double0, double0, double0, (Double) null, double0);
      String string0 = cart0.getCouponAppliedOnCart();
      assertEquals("AgB.sG6Y\"+h,pM", string0);
      assertEquals(", cartDiscountTotal=", cart0.getCustomerTenantId());
      assertEquals("", cart0.getRestaurantTenantId());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Integer integer0 = new Integer(2676);
      Double double0 = new Double(1083.82949644);
      Cart cart0 = new Cart("", "", (List<Item>) null, integer0, "", double0, double0, double0, double0, double0, double0, double0);
      String string0 = cart0.getCouponAppliedOnCart();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Vector<Item> vector0 = new Vector<Item>();
      Integer integer0 = new Integer(125);
      Double double0 = new Double(1011.61053789264);
      Double double1 = new Double(0.0);
      Cart cart0 = new Cart(", cartGrandTotal=", ", cartGrandTotal=", vector0, integer0, ", cartGrandTotal=", double0, double0, double0, double1, double0, double1, double1);
      Double double2 = cart0.getCartTotalSgstPercentage();
      assertEquals(1011.61053789264, cart0.getCartDiscountTotal(), 0.01);
      assertEquals(0.0, (double)double2, 0.01);
      assertEquals(0.0, cart0.getCartGrandTotal(), 0.01);
      assertEquals(1011.61053789264, cart0.getCartDeliveryFee(), 0.01);
      assertEquals(0.0, cart0.getCartTotalCgstPercentage(), 0.01);
      assertEquals(1011.61053789264, cart0.getCartTotal(), 0.01);
      assertEquals(1011.61053789264, cart0.getCartItemPriceTotal(), 0.01);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Double double0 = new Double((-1513.94));
      Cart cart0 = new Cart("", "", (List<Item>) null, integer0, "", double0, double0, double0, double0, double0, (Double) null, double0);
      Double double1 = cart0.getCartTotalSgstPercentage();
      assertEquals((-1513.94), (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      ArrayList<Item> arrayList0 = new ArrayList<Item>();
      Integer integer0 = new Integer((-3292));
      Double double0 = new Double(2769.933);
      Cart cart0 = new Cart("", "com.d365lab.eatery.restaurantcustomerorchestrator.model.Cart", arrayList0, integer0, "", double0, double0, double0, double0, double0, double0, double0);
      cart0.getCartTotalSgstPercentage();
      assertEquals("", cart0.getCouponAppliedOnCart());
      assertEquals("com.d365lab.eatery.restaurantcustomerorchestrator.model.Cart", cart0.getCustomerTenantId());
      assertEquals("", cart0.getRestaurantTenantId());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Stack<Item> stack0 = new Stack<Item>();
      Integer integer0 = new Integer(0);
      Double double0 = new Double(0);
      Cart cart0 = new Cart("com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", "com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", stack0, integer0, "com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", double0, double0, double0, double0, double0, double0, double0);
      Double double1 = cart0.getCartTotalCgstPercentage();
      assertEquals(0.0, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Integer integer0 = new Integer(1);
      Double double0 = new Double(1);
      Cart cart0 = new Cart("NP_Ee((W4G0?;FX6~B", "NP_Ee((W4G0?;FX6~B", (List<Item>) null, integer0, (String) null, double0, double0, double0, double0, double0, double0, (Double) null);
      Double double1 = cart0.getCartTotalCgstPercentage();
      assertEquals(1.0, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Double double0 = new Double(1.0);
      Double double1 = new Double((-1372.8651297025679));
      Cart cart0 = new Cart("", "", (List<Item>) null, integer0, "@R", double0, double0, double0, double0, double0, double1, double0);
      Double double2 = cart0.getCartTotalCgstPercentage();
      assertEquals("", cart0.getRestaurantTenantId());
      assertEquals(1.0, cart0.getCartGrandTotal(), 0.01);
      assertEquals(1.0, cart0.getCartItemPriceTotal(), 0.01);
      assertEquals(1.0, cart0.getCartTotal(), 0.01);
      assertEquals(1.0, cart0.getCartTotalSgstPercentage(), 0.01);
      assertEquals((-1372.8651297025679), (double)double2, 0.01);
      assertEquals("@R", cart0.getCouponAppliedOnCart());
      assertEquals(1.0, cart0.getCartDiscountTotal(), 0.01);
      assertEquals(1.0, cart0.getCartDeliveryFee(), 0.01);
      assertEquals("", cart0.getCustomerTenantId());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Integer integer0 = new Integer((-423));
      Double double0 = new Double(0.0);
      Cart cart0 = new Cart((String) null, ",", (List<Item>) null, integer0, ", cartItemPriceTotal=", double0, double0, double0, double0, double0, double0, double0);
      cart0.getCartTotal();
      assertEquals(", cartItemPriceTotal=", cart0.getCouponAppliedOnCart());
      assertEquals(",", cart0.getCustomerTenantId());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = new Double((-4015.0));
      cart0.setCartTotal(double0);
      Double double1 = cart0.getCartTotal();
      assertEquals((-4015.0), (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Double double0 = new Double(485.279829538);
      Cart cart0 = new Cart("/NdlL`(kCZ-y", "/NdlL`(kCZ-y", (List<Item>) null, integer0, "/NdlL`(kCZ-y", double0, double0, double0, double0, double0, double0, double0);
      Double double1 = cart0.getCartTotal();
      assertEquals(485.279829538, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Cart cart0 = new Cart();
      Stack<Item> stack0 = new Stack<Item>();
      cart0.setCartMenuList(stack0);
      List<Item> list0 = cart0.getCartMenuList();
      assertTrue(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Stack<Item> stack0 = new Stack<Item>();
      Integer integer0 = new Integer(0);
      Double double0 = new Double(0);
      Cart cart0 = new Cart("com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", "com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", stack0, integer0, "com.d365lab.eatery.restaurantcustomerorchestrator.model.Item", double0, double0, double0, double0, double0, double0, double0);
      Item item0 = new Item();
      stack0.add(item0);
      List<Item> list0 = cart0.getCartMenuList();
      assertTrue(list0.contains(item0));
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Double double0 = new Double((-1513.94));
      Double double1 = new Double(0);
      Cart cart0 = new Cart("", "", (List<Item>) null, integer0, "", double0, double0, double0, double0, double1, (Double) null, double0);
      Double double2 = cart0.getCartItemPriceTotal();
      assertEquals((-1513.94), cart0.getCartGrandTotal(), 0.01);
      assertEquals((-1513.94), cart0.getCartDeliveryFee(), 0.01);
      assertNotNull(double2);
      assertEquals(0.0, (double)double2, 0.01);
      assertEquals((-1513.94), cart0.getCartDiscountTotal(), 0.01);
      assertEquals((-1513.94), cart0.getCartTotal(), 0.01);
      assertEquals((-1513.94), cart0.getCartTotalSgstPercentage(), 0.01);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Stack<Item> stack0 = new Stack<Item>();
      Integer integer0 = new Integer((-981));
      Double double0 = new Double((-981));
      Cart cart0 = new Cart("+?+ld!)} ;F~q3\"18d", "+?+ld!)} ;F~q3\"18d", stack0, integer0, "+?+ld!)} ;F~q3\"18d", double0, double0, double0, double0, double0, double0, double0);
      Double double1 = cart0.getCartItemPriceTotal();
      assertEquals((-981.0), (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Double double0 = new Double(485.279829538);
      Cart cart0 = new Cart("/NdlL`(kCZ-y", "/NdlL`(kCZ-y", (List<Item>) null, integer0, "/NdlL`(kCZ-y", double0, double0, double0, double0, double0, double0, double0);
      Double double1 = cart0.getCartItemPriceTotal();
      assertEquals(485.279829538, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Double double0 = new Double((-4759.840900016511));
      Double double1 = new Double(0);
      Cart cart0 = new Cart("yT_<QoL0QsrD+q", "yT_<QoL0QsrD+q", (List<Item>) null, integer0, "`%=:=7zpZjv,J'gR", double0, double0, double1, double1, double1, double1, double0);
      Double double2 = cart0.getCartGrandTotal();
      assertEquals(0.0, (double)double2, 0.01);
      assertEquals(0.0, cart0.getCartDiscountTotal(), 0.01);
      assertEquals(0.0, cart0.getCartTotalCgstPercentage(), 0.01);
      assertEquals((-4759.840900016511), cart0.getCartTotalSgstPercentage(), 0.01);
      assertEquals((-4759.840900016511), cart0.getCartTotal(), 0.01);
      assertEquals(0.0, cart0.getCartItemPriceTotal(), 0.01);
      assertEquals("`%=:=7zpZjv,J'gR", cart0.getCouponAppliedOnCart());
      assertEquals("yT_<QoL0QsrD+q", cart0.getRestaurantTenantId());
      assertEquals((-4759.840900016511), cart0.getCartDeliveryFee(), 0.01);
      assertEquals("yT_<QoL0QsrD+q", cart0.getCustomerTenantId());
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Integer integer0 = new Integer((-1));
      Double double0 = new Double(0.0);
      Double double1 = new Double((-653.8880434));
      Cart cart0 = new Cart("", "", (List<Item>) null, integer0, "", double0, double0, double1, double1, (Double) null, (Double) null, double1);
      Double double2 = cart0.getCartGrandTotal();
      assertEquals((-653.8880434), cart0.getCartDiscountTotal(), 0.01);
      assertEquals((-653.8880434), cart0.getCartTotalSgstPercentage(), 0.01);
      assertNotNull(double2);
      assertEquals(0.0, cart0.getCartTotal(), 0.01);
      assertEquals((-653.8880434), (double)double2, 0.01);
      assertEquals(0.0, cart0.getCartDeliveryFee(), 0.01);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Vector<Item> vector0 = new Vector<Item>();
      Integer integer0 = new Integer((-1209));
      Double double0 = new Double(4856.6235);
      Cart cart0 = new Cart("", "requestFactory", vector0, integer0, "", double0, double0, double0, double0, double0, double0, double0);
      cart0.getCartGrandTotal();
      assertEquals("requestFactory", cart0.getCustomerTenantId());
      assertEquals("", cart0.getCouponAppliedOnCart());
      assertEquals("", cart0.getRestaurantTenantId());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Double double0 = new Double(0);
      Cart cart0 = new Cart("", "", (List<Item>) null, integer0, "", (Double) null, (Double) null, double0, double0, (Double) null, double0, double0);
      Double double1 = cart0.getCartDiscountTotal();
      assertEquals(0.0, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Integer integer0 = new Integer((-1201));
      Double double0 = new Double((-1201));
      Cart cart0 = new Cart("@'-9BM[<I<]NA]m", "Q^", (List<Item>) null, integer0, "Jd%B)Z_#[G[)uwLFP%x", double0, double0, double0, double0, double0, double0, double0);
      cart0.getCartDiscountTotal();
      assertEquals("Jd%B)Z_#[G[)uwLFP%x", cart0.getCouponAppliedOnCart());
      assertEquals("Q^", cart0.getCustomerTenantId());
      assertEquals("@'-9BM[<I<]NA]m", cart0.getRestaurantTenantId());
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = new Double(249.0);
      cart0.setCartDiscountTotal(double0);
      Double double1 = cart0.getCartDiscountTotal();
      assertEquals(249.0, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      LinkedList<Item> linkedList0 = new LinkedList<Item>();
      Integer integer0 = new Integer((-1682));
      Double double0 = new Double((-1682));
      Double double1 = new Double(1.0);
      Cart cart0 = new Cart("kQm;lo*1FdP", "kQm;lo*1FdP", linkedList0, integer0, "F$.1V", double0, double1, double0, double1, double0, double0, double0);
      Double double2 = cart0.getCartDeliveryFee();
      assertEquals((-1682.0), cart0.getCartItemPriceTotal(), 0.01);
      assertEquals(1.0, cart0.getCartGrandTotal(), 0.01);
      assertEquals("F$.1V", cart0.getCouponAppliedOnCart());
      assertEquals((-1682.0), cart0.getCartTotalSgstPercentage(), 0.01);
      assertEquals((-1682.0), cart0.getCartTotal(), 0.01);
      assertEquals((-1682.0), cart0.getCartDiscountTotal(), 0.01);
      assertEquals((-1682.0), cart0.getCartTotalCgstPercentage(), 0.01);
      assertEquals("kQm;lo*1FdP", cart0.getRestaurantTenantId());
      assertEquals(1.0, (double)double2, 0.01);
      assertEquals("kQm;lo*1FdP", cart0.getCustomerTenantId());
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      ArrayList<Item> arrayList0 = new ArrayList<Item>();
      Integer integer0 = new Integer((-3697));
      Double double0 = new Double(0.0);
      Cart cart0 = new Cart("IfD?b2fCb#)", "IfD?b2fCb#)", arrayList0, integer0, "Revision %s of entity %s - Revision metadata %s", double0, double0, double0, double0, double0, double0, double0);
      cart0.getCartDeliveryFee();
      assertEquals("Revision %s of entity %s - Revision metadata %s", cart0.getCouponAppliedOnCart());
      assertEquals("IfD?b2fCb#)", cart0.getCustomerTenantId());
      assertEquals("IfD?b2fCb#)", cart0.getRestaurantTenantId());
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      LinkedList<Item> linkedList0 = new LinkedList<Item>();
      Integer integer0 = new Integer((-1682));
      Double double0 = new Double((-1682));
      Cart cart0 = new Cart("kQm;lo*1FdP", "kQm;lo*1FdP", linkedList0, integer0, "F$.1V", double0, double0, double0, double0, double0, double0, double0);
      cart0.getCartDeliveryFee();
      assertEquals("F$.1V", cart0.getCouponAppliedOnCart());
      assertEquals("kQm;lo*1FdP", cart0.getCustomerTenantId());
      assertEquals("kQm;lo*1FdP", cart0.getRestaurantTenantId());
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = new Double((-548.45361402548));
      cart0.setCartDeliveryFee(double0);
      Double double1 = cart0.getCartDeliveryFee();
      assertEquals((-548.45361402548), (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = cart0.getCartTotalCgstPercentage();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Integer integer0 = new Integer(889);
      Double double0 = new Double(889);
      Cart cart0 = new Cart("com.d365lab.eatery.restaurastcustomerorchestrator.model.Item", "com.d365lab.eatery.restaurastcustomerorchestrator.model.Item", (List<Item>) null, integer0, "com.d365lab.eatery.restaurastcustomerorchestrator.model.Item", double0, double0, double0, double0, double0, double0, double0);
      String string0 = cart0.getCustomerTenantId();
      assertEquals("com.d365lab.eatery.restaurastcustomerorchestrator.model.Item", string0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Cart cart0 = new Cart();
      List<Item> list0 = cart0.getCartMenuList();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Cart cart0 = new Cart();
      cart0.setRestaurantTenantId("BI`TB^hWr?M=@( ");
      String string0 = cart0.getRestaurantTenantId();
      assertEquals("BI`TB^hWr?M=@( ", string0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      Cart cart0 = new Cart();
      Integer integer0 = cart0.getIsOrderPlaced();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Cart cart0 = new Cart();
      cart0.setCouponAppliedOnCart("BI`TB^hWr?M=@( ");
      assertNull(cart0.getCartDiscountTotal());
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      Cart cart0 = new Cart();
      cart0.setCartTotalSgstPercentage((Double) null);
      assertNull(cart0.getCartDeliveryFee());
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      Cart cart0 = new Cart();
      cart0.setCustomerTenantId("4`0BA)4");
      assertEquals("4`0BA)4", cart0.getCustomerTenantId());
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      Cart cart0 = new Cart();
      cart0.setCartGrandTotal((Double) null);
      assertNull(cart0.getIsOrderPlaced());
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      Cart cart0 = new Cart();
      Date date0 = cart0.getCreatedAt();
      assertNull(date0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Cart cart0 = new Cart();
      Date date0 = cart0.getUpdatedAt();
      assertNull(date0);
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      Cart cart0 = new Cart();
      String string0 = cart0.getCustomerTenantId();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      Cart cart0 = new Cart();
      cart0.setIsOrderPlaced((Integer) null);
      assertNull(cart0.getCartGrandTotal());
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = cart0.getCartTotalSgstPercentage();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = cart0.getCartDeliveryFee();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      Cart cart0 = new Cart();
      cart0.setCartTotalCgstPercentage((Double) null);
      assertNull(cart0.getCartDiscountTotal());
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      Cart cart0 = new Cart();
      String string0 = cart0.toString();
      assertEquals("Cart{restaurantTenantId='null', customerTenantId='null', cartMenuList=null, isOrderPlaced=null, couponAppliedOnCart='null', cartTotal=null, cartDeliveryFee=null, cartDiscountTotal=null, cartGrandTotal=null, cartItemPriceTotal=null, cartTotalCgstPercentage=null, cartTotalSgstPercentage=null, createdAt=null, updatedAt=null}", string0);
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = cart0.getCartTotal();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = cart0.getCartGrandTotal();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = cart0.getCartDiscountTotal();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      Cart cart0 = new Cart();
      cart0.setCartItemPriceTotal((Double) null);
      assertNull(cart0.getCartDeliveryFee());
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      Cart cart0 = new Cart();
      String string0 = cart0.getCouponAppliedOnCart();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      Cart cart0 = new Cart();
      Double double0 = cart0.getCartItemPriceTotal();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      Cart cart0 = new Cart();
      String string0 = cart0.getRestaurantTenantId();
      assertNull(string0);
  }
}