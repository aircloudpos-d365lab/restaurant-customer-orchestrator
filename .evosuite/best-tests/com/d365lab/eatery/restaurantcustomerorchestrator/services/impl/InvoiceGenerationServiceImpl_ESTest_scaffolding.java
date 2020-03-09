/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Mon Mar 09 08:57:41 GMT 2020
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
public class InvoiceGenerationServiceImpl_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.InvoiceGenerationServiceImpl"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(InvoiceGenerationServiceImpl_ESTest_scaffolding.class.getClassLoader() ,
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantMenuWithCustomization",
      "org.aspectj.lang.reflect.SourceLocation",
      "org.springframework.beans.factory.annotation.Autowired",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.CartService",
      "org.aspectj.lang.reflect.AdviceSignature",
      "com.fasterxml.jackson.annotation.JacksonAnnotation",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.InvoiceGenerationServiceImpl",
      "org.aspectj.lang.annotation.Aspect",
      "org.aspectj.runtime.reflect.SignatureImpl",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.Item",
      "org.springframework.data.jpa.domain.support.AuditingEntityListener",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantOrder",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.enums.RestaurantPaymentMode",
      "org.springframework.beans.factory.aspectj.ConfigurableObject",
      "com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.RestaurantCustomerOrchestratorException",
      "org.aspectj.lang.reflect.UnlockSignature",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.InvoiceGenerationService",
      "org.aspectj.lang.reflect.FieldSignature",
      "org.aspectj.lang.Signature",
      "org.springframework.beans.factory.annotation.Autowire",
      "org.aspectj.runtime.reflect.MethodSignatureImpl",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantPaymentOptions",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantInfo",
      "org.springframework.beans.factory.DisposableBean",
      "org.aspectj.lang.reflect.ConstructorSignature",
      "com.fasterxml.jackson.annotation.JsonIgnoreProperties",
      "org.aspectj.lang.reflect.MemberSignature",
      "org.aspectj.lang.reflect.CatchClauseSignature",
      "org.aspectj.runtime.reflect.CodeSignatureImpl",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantMenuInputPayload",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenuCustomization",
      "org.aspectj.runtime.reflect.Factory",
      "org.aspectj.runtime.reflect.SourceLocationImpl",
      "org.springframework.beans.factory.annotation.Configurable",
      "org.aspectj.lang.reflect.LockSignature",
      "org.springframework.beans.factory.Aware",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderOutputPayload",
      "org.springframework.beans.factory.InitializingBean",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantDetails",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderInputPayload",
      "org.aspectj.runtime.reflect.MemberSignatureImpl",
      "org.aspectj.runtime.reflect.SignatureImpl$Cache",
      "org.json.simple.parser.ParseException",
      "org.springframework.stereotype.Service",
      "org.springframework.beans.factory.BeanFactoryAware",
      "org.aspectj.runtime.reflect.ConstructorSignatureImpl",
      "org.aspectj.lang.JoinPoint$StaticPart",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrchestratorService",
      "org.springframework.stereotype.Indexed",
      "org.springframework.beans.factory.aspectj.AnnotationBeanConfigurerAspect",
      "org.aspectj.lang.reflect.CodeSignature",
      "org.springframework.beans.factory.aspectj.AbstractInterfaceDrivenDependencyInjectionAspect",
      "org.aspectj.lang.JoinPoint",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrderService",
      "org.springframework.beans.factory.aspectj.AbstractDependencyInjectionAspect",
      "org.aspectj.runtime.reflect.JoinPointImpl$StaticPartImpl",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenu",
      "org.aspectj.lang.JoinPoint$EnclosingStaticPart",
      "org.aspectj.lang.reflect.InitializerSignature",
      "org.springframework.beans.factory.ObjectFactory",
      "org.springframework.stereotype.Component",
      "org.aspectj.lang.reflect.MethodSignature",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.OrderInvoice"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantOrder", false, InvoiceGenerationServiceImpl_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantDetails", false, InvoiceGenerationServiceImpl_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("com.d365lab.eatery.restaurantcustomerorchestrator.services.CartService", false, InvoiceGenerationServiceImpl_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrchestratorService", false, InvoiceGenerationServiceImpl_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrderService", false, InvoiceGenerationServiceImpl_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(InvoiceGenerationServiceImpl_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.InvoiceGenerationServiceImpl",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantDetails",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantOrder",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.OrderInvoice",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantOrderInputPayload",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantInfo"
    );
  }
}
