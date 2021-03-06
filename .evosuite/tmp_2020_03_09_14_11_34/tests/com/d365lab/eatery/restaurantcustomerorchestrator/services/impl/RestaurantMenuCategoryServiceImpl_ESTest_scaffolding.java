/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Mon Mar 09 09:06:40 GMT 2020
 */

package com.d365lab.eatery.restaurantcustomerorchestrator.services.impl;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class RestaurantMenuCategoryServiceImpl_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.RestaurantMenuCategoryServiceImpl"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    try { initMocksToAvoidTimeoutsInTheTests(); } catch(ClassNotFoundException e) {} 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "US-ASCII"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("java.io.tmpdir", "/var/folders/sg/h2xqy5kd0k535448l5nd03j95y0bpz/T/"); 
    java.lang.System.setProperty("user.country", "IN"); 
    java.lang.System.setProperty("user.dir", "/Users/ronik.basak/Documents/Ronik_Personal_Documents/D365/backend/restaurant-customer-orchestrator"); 
    java.lang.System.setProperty("user.home", "/Users/ronik.basak"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.name", "ronik.basak"); 
    java.lang.System.setProperty("user.timezone", "Asia/Kolkata"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(RestaurantMenuCategoryServiceImpl_ESTest_scaffolding.class.getClassLoader() ,
      "org.springframework.data.jpa.repository.Query",
      "org.springframework.data.repository.PagingAndSortingRepository",
      "org.springframework.beans.factory.annotation.Autowired",
      "org.springframework.data.repository.CrudRepository",
      "org.springframework.data.domain.Page",
      "org.springframework.data.domain.Example",
      "org.springframework.data.annotation.QueryAnnotation",
      "org.springframework.data.domain.Slice",
      "org.springframework.data.repository.query.QueryByExampleExecutor",
      "org.springframework.stereotype.Component",
      "org.springframework.data.util.Streamable",
      "org.springframework.stereotype.Service",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.RestaurantMenuCategoryServiceImpl",
      "org.springframework.data.repository.Repository",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenuCategory",
      "org.springframework.data.domain.Sort",
      "org.springframework.data.domain.Pageable",
      "org.springframework.stereotype.Indexed",
      "org.springframework.stereotype.Repository",
      "com.d365lab.eatery.restaurantcustomerorchestrator.repositories.RestaurantMenuCategoryRepository",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantMenuCategoryService",
      "org.springframework.data.jpa.repository.JpaRepository"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("com.d365lab.eatery.restaurantcustomerorchestrator.repositories.RestaurantMenuCategoryRepository", false, RestaurantMenuCategoryServiceImpl_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(RestaurantMenuCategoryServiceImpl_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.RestaurantMenuCategoryServiceImpl"
    );
  }
}
