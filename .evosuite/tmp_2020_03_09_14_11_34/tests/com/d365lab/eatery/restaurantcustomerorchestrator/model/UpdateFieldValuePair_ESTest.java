/*
 * This file was automatically generated by EvoSuite
 * Mon Mar 09 09:02:57 GMT 2020
 */

package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import org.junit.Test;
import static org.junit.Assert.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.model.UpdateFieldValuePair;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UpdateFieldValuePair_ESTest extends UpdateFieldValuePair_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      UpdateFieldValuePair updateFieldValuePair0 = new UpdateFieldValuePair("", "");
      updateFieldValuePair0.setNewValue((String) null);
      String string0 = updateFieldValuePair0.getNewValue();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      UpdateFieldValuePair updateFieldValuePair0 = new UpdateFieldValuePair("", "");
      updateFieldValuePair0.setFieldName((String) null);
      String string0 = updateFieldValuePair0.getFieldName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      UpdateFieldValuePair updateFieldValuePair0 = new UpdateFieldValuePair();
      updateFieldValuePair0.setFieldName("~}");
      String string0 = updateFieldValuePair0.getFieldName();
      assertEquals("~}", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      UpdateFieldValuePair updateFieldValuePair0 = new UpdateFieldValuePair("", "");
      String string0 = updateFieldValuePair0.getFieldName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      UpdateFieldValuePair updateFieldValuePair0 = new UpdateFieldValuePair("", "");
      updateFieldValuePair0.setNewValue("BM)Ko\"PBd");
      String string0 = updateFieldValuePair0.getNewValue();
      assertEquals("BM)Ko\"PBd", string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      UpdateFieldValuePair updateFieldValuePair0 = new UpdateFieldValuePair("", "");
      String string0 = updateFieldValuePair0.getNewValue();
      assertEquals("", string0);
  }
}
