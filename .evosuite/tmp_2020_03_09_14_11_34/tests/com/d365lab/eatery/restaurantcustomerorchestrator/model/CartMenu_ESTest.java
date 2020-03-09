/*
 * This file was automatically generated by EvoSuite
 * Mon Mar 09 09:04:36 GMT 2020
 */

package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import org.junit.Test;
import static org.junit.Assert.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.CartMenu;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.Item;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CartMenu_ESTest extends CartMenu_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      CartMenu cartMenu0 = new CartMenu();
      List<Item> list0 = cartMenu0.getCartMenuList();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      LinkedList<Item> linkedList0 = new LinkedList<Item>();
      Item item0 = new Item();
      linkedList0.add(item0);
      CartMenu cartMenu0 = new CartMenu(linkedList0);
      List<Item> list0 = cartMenu0.getCartMenuList();
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      LinkedList<Item> linkedList0 = new LinkedList<Item>();
      CartMenu cartMenu0 = new CartMenu(linkedList0);
      List<Item> list0 = cartMenu0.getCartMenuList();
      assertTrue(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      CartMenu cartMenu0 = new CartMenu();
      cartMenu0.setCartMenuList((List<Item>) null);
  }
}
