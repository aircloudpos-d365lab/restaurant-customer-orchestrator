/*
 * This file was automatically generated by EvoSuite
 * Mon Mar 09 08:59:36 GMT 2020
 */

package com.d365lab.eatery.restaurantcustomerorchestrator.utils.restaurantlogin;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.d365lab.eatery.restaurantcustomerorchestrator.utils.restaurantlogin.PasswordUtils;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class PasswordUtils_ESTest extends PasswordUtils_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      PasswordUtils.generateSecurePassword("", " Pkz2Xxg=|;184Gz");
      PasswordUtils.getSalt(0);
      PasswordUtils.getSalt(0);
      PasswordUtils passwordUtils0 = new PasswordUtils();
      PasswordUtils.getSalt(0);
      PasswordUtils.verifyUserPassword("", "HBQiH7eIr9N5ngWxBKLzHwCkZmlCQ1IpevCSE+7lVjg=", " Pkz2Xxg=|;184Gz");
      char[] charArray0 = new char[0];
      byte[] byteArray0 = new byte[7];
      byteArray0[0] = (byte) (-45);
      byteArray0[1] = (byte)0;
      byteArray0[2] = (byte)0;
      byteArray0[3] = (byte) (-1);
      byteArray0[4] = (byte) (-79);
      byteArray0[5] = (byte)1;
      byteArray0[6] = (byte)49;
      PasswordUtils.hash(charArray0, byteArray0);
      PasswordUtils.getSalt(5864);
      PasswordUtils.generateSecurePassword("HBQiH7eIr9N5ngWxBKLzHwCkZmlCQ1IpevCSE+7lVjg=", "Z\"VrDNfn?+8f.");
      // Undeclared exception!
      try { 
        PasswordUtils.generateSecurePassword("HBQiH7eIr9N5ngWxBKLzHwCkZmlCQ1IpevCSE+7lVjg=", "");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // the salt parameter must not be empty
         //
         verifyException("javax.crypto.spec.PBEKeySpec", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      PasswordUtils passwordUtils0 = new PasswordUtils();
      char[] charArray0 = new char[1];
      charArray0[0] = 'b';
      byte[] byteArray0 = new byte[9];
      byteArray0[0] = (byte)0;
      byteArray0[1] = (byte)125;
      byteArray0[2] = (byte)0;
      byteArray0[3] = (byte)0;
      byteArray0[4] = (byte)41;
      byteArray0[5] = (byte) (-117);
      byteArray0[6] = (byte)47;
      byteArray0[7] = (byte)0;
      byteArray0[8] = (byte)25;
      PasswordUtils.hash(charArray0, byteArray0);
      PasswordUtils.getSalt(0);
      int int0 = 10000;
      // Undeclared exception!
      PasswordUtils.getSalt(10000);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      // Undeclared exception!
      try { 
        PasswordUtils.generateSecurePassword((String) null, (String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.utils.restaurantlogin.PasswordUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      // Undeclared exception!
      try { 
        PasswordUtils.verifyUserPassword((String) null, "com.d365lab.eatery.restaurantcustomerorchestrator.utils.restaurantlogin.PasswordUtils", "com.d365lab.eatery.restaurantcustomerorchestrator.utils.restaurantlogin.PasswordUtils");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.d365lab.eatery.restaurantcustomerorchestrator.utils.restaurantlogin.PasswordUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      char[] charArray0 = new char[0];
      byte[] byteArray0 = new byte[0];
      // Undeclared exception!
      try { 
        PasswordUtils.hash(charArray0, byteArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // the salt parameter must not be empty
         //
         verifyException("javax.crypto.spec.PBEKeySpec", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      PasswordUtils.generateSecurePassword("Error while hashing a password: ", "Error while hashing a password: ");
      PasswordUtils.getSalt(0);
      PasswordUtils.getSalt(731);
      PasswordUtils.verifyUserPassword("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", "?~Q", ":I=tO8!e&ZGiCR");
      PasswordUtils passwordUtils0 = new PasswordUtils();
      PasswordUtils.generateSecurePassword("iLlEBE/fBHPMrCyMY5si/7MvKC6eDwAj1zDvefPlBtU=", "Error while hashing a password: ");
      String string0 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
      PasswordUtils.verifyUserPassword("el+3L'4.(jvvvA@^.", "Hw7{m E!T+ji5", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
      char[] charArray0 = new char[1];
      charArray0[0] = 'D';
      byte[] byteArray0 = new byte[5];
      byteArray0[0] = (byte)80;
      byteArray0[1] = (byte) (-99);
      byteArray0[2] = (byte) (-10);
      byteArray0[3] = (byte) (-60);
      byteArray0[4] = (byte)0;
      byte[] byteArray1 = PasswordUtils.hash(charArray0, byteArray0);
      PasswordUtils.hash(charArray0, byteArray1);
      // Undeclared exception!
      try { 
        PasswordUtils.getSalt((-1));
        fail("Expecting exception: NegativeArraySizeException");
      
      } catch(NegativeArraySizeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.lang.AbstractStringBuilder", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      PasswordUtils.generateSecurePassword("(cQ", "PBKDF2WithHmacSHA1");
      PasswordUtils passwordUtils0 = new PasswordUtils();
      PasswordUtils.getSalt(352);
      PasswordUtils.generateSecurePassword("(cQ", "MLFOhuRvRWS4QbzOuQhKRz50NjeyZZ7+BE97eSjDgik=");
      PasswordUtils.verifyUserPassword("(cQ", "~LRmr?@@%O$1)p%I", "PBKDF2WithHmacSHA1");
      PasswordUtils.generateSecurePassword("com.d365lab.eatery.restaurantcustomerorchestrator.utils.restaurantlogin.PasswordUtils", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
      char[] charArray0 = new char[2];
      char char0 = '+';
      charArray0[0] = '+';
      char char1 = '>';
      charArray0[1] = '>';
      byte[] byteArray0 = null;
      // Undeclared exception!
      try { 
        PasswordUtils.hash(charArray0, (byte[]) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // the salt parameter must be non-null
         //
         verifyException("javax.crypto.spec.PBEKeySpec", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      char[] charArray0 = new char[1];
      charArray0[0] = '.';
      byte[] byteArray0 = new byte[1];
      byteArray0[0] = (byte)0;
      PasswordUtils.hash(charArray0, byteArray0);
      // Undeclared exception!
      try { 
        PasswordUtils.verifyUserPassword("", "", "");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // the salt parameter must not be empty
         //
         verifyException("javax.crypto.spec.PBEKeySpec", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      PasswordUtils.getSalt(76);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      PasswordUtils.verifyUserPassword("W[)!M1AIkg/b", "W[)!M1AIkg/b", "W[)!M1AIkg/b");
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      PasswordUtils.verifyUserPassword("aIE?B$", "iT=3, #b)dHX72N`o>", "aIE?B$");
      PasswordUtils.verifyUserPassword("iT=3, #b)dHX72N`o>", "iT=3, #b)dHX72N`o>", "aIE?B$");
      PasswordUtils passwordUtils0 = new PasswordUtils();
      String string0 = PasswordUtils.getSalt(2234);
      assertNotNull(string0);
  }
}