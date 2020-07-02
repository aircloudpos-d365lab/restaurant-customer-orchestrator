/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Mon Mar 09 08:55:36 GMT 2020
 */

package com.d365lab.eatery.restaurantcustomerorchestrator.controllers;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class CustomerOrchestratorController_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.d365lab.eatery.restaurantcustomerorchestrator.controllers.CustomerOrchestratorController"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(CustomerOrchestratorController_ESTest_scaffolding.class.getClassLoader() ,
      "org.springframework.core.ParameterNameDiscoverer",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.CustomerAddress",
      "org.springframework.http.ContentDisposition$Builder",
      "org.springframework.beans.factory.annotation.Autowired",
      "org.aspectj.lang.reflect.AdviceSignature",
      "org.springframework.http.CacheControl",
      "org.springframework.data.domain.Sort$Direction",
      "org.springframework.data.domain.Sort",
      "org.springframework.core.ParameterizedTypeReference$1",
      "org.springframework.core.NestedExceptionUtils",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.CustomerOrchestratorService",
      "org.springframework.beans.factory.aspectj.ConfigurableObject",
      "org.aspectj.lang.Signature",
      "org.springframework.data.domain.Page",
      "org.springframework.web.bind.annotation.RestController",
      "org.springframework.util.CollectionUtils",
      "org.springframework.data.util.Streamable",
      "org.springframework.beans.factory.DisposableBean",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantCustomerMap",
      "org.springframework.util.ConcurrentReferenceHashMap$Task",
      "org.springframework.data.domain.Unpaged",
      "com.fasterxml.jackson.annotation.JsonIgnoreProperties",
      "org.aspectj.runtime.reflect.CodeSignatureImpl",
      "org.springframework.util.ConcurrentReferenceHashMap$Entry",
      "org.springframework.core.ParameterizedTypeReference",
      "org.springframework.util.LinkedCaseInsensitiveMap",
      "org.aspectj.runtime.reflect.Factory",
      "org.springframework.http.HttpStatus$Series",
      "org.springframework.http.MediaType$1",
      "org.springframework.util.ConcurrentReferenceHashMap$TaskOption",
      "org.springframework.data.util.MethodInvocationRecorder$Recorded$ToCollectionConverter",
      "org.springframework.util.ConcurrentReferenceHashMap$ReferenceManager",
      "org.springframework.util.ConcurrentReferenceHashMap",
      "org.springframework.util.ConcurrentReferenceHashMap$ReferenceType",
      "org.aspectj.runtime.reflect.MemberSignatureImpl",
      "org.springframework.beans.factory.BeanCreationException",
      "org.springframework.stereotype.Service",
      "org.springframework.beans.factory.BeanFactoryAware",
      "org.aspectj.runtime.reflect.ConstructorSignatureImpl",
      "org.aspectj.lang.JoinPoint$StaticPart",
      "org.springframework.util.MimeType$SpecificityComparator",
      "org.springframework.stereotype.Indexed",
      "org.springframework.core.ResolvableType$EmptyType",
      "com.d365lab.eatery.restaurantcustomerorchestrator.controllers.CustomerOrchestratorController",
      "org.springframework.beans.factory.aspectj.AbstractDependencyInjectionAspect",
      "org.springframework.util.InvalidMimeTypeException",
      "org.springframework.util.ConcurrentReferenceHashMap$1",
      "org.springframework.util.ConcurrentReferenceHashMap$2",
      "org.springframework.util.ConcurrentReferenceHashMap$3",
      "org.springframework.util.ConcurrentReferenceHashMap$4",
      "org.aspectj.lang.JoinPoint$EnclosingStaticPart",
      "org.springframework.http.HttpMethod",
      "org.springframework.util.MultiValueMap",
      "org.springframework.util.ConcurrentReferenceHashMap$Entries",
      "org.springframework.beans.BeansException",
      "org.aspectj.lang.reflect.InitializerSignature",
      "org.springframework.util.LinkedCaseInsensitiveMap$ValuesIterator",
      "org.aspectj.lang.NoAspectBoundException",
      "org.springframework.util.CollectionUtils$MultiValueMapAdapter",
      "org.springframework.util.LinkedCaseInsensitiveMap$1",
      "org.springframework.http.HttpStatus",
      "org.springframework.beans.factory.ObjectFactory",
      "org.springframework.core.ResolvableType$1",
      "org.springframework.beans.factory.BeanFactory",
      "org.springframework.beans.factory.aspectj.AbstractInterfaceDrivenDependencyInjectionAspect$ConfigurableDeserializationSupport",
      "org.springframework.util.ConcurrentReferenceHashMap$5",
      "org.springframework.util.LinkedMultiValueMap",
      "org.aspectj.lang.reflect.SourceLocation",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntrySetIterator",
      "org.springframework.util.ConcurrentReferenceHashMap$Reference",
      "org.springframework.util.ConcurrentReferenceHashMap$Segment",
      "com.fasterxml.jackson.annotation.JacksonAnnotation",
      "org.springframework.util.MimeType",
      "com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.CustomerOrchestratorException",
      "org.aspectj.lang.annotation.Aspect",
      "org.aspectj.runtime.reflect.SignatureImpl",
      "org.springframework.core.MethodParameter",
      "org.springframework.util.LinkedCaseInsensitiveMap$KeySetIterator",
      "org.springframework.data.jpa.domain.support.AuditingEntityListener",
      "org.springframework.data.domain.Pageable",
      "org.springframework.core.ResolvableType",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntryIterator",
      "org.springframework.core.NestedRuntimeException",
      "org.aspectj.lang.reflect.UnlockSignature",
      "org.springframework.http.HttpHeaders",
      "org.springframework.http.MediaType",
      "org.springframework.data.domain.Chunk",
      "org.aspectj.lang.reflect.FieldSignature",
      "org.springframework.web.bind.annotation.RequestMethod",
      "org.springframework.beans.factory.annotation.Autowire",
      "org.aspectj.runtime.reflect.MethodSignatureImpl",
      "org.springframework.data.domain.Slice",
      "org.springframework.data.domain.Sort$NullHandling",
      "org.springframework.http.HttpEntity",
      "org.springframework.core.SerializableTypeWrapper$TypeProvider",
      "org.aspectj.lang.reflect.ConstructorSignature",
      "org.springframework.core.ResolvableType$VariableResolver",
      "org.springframework.http.ResponseEntity$HeadersBuilder",
      "org.springframework.util.ConcurrentReferenceHashMap$Restructure",
      "org.springframework.data.domain.PageImpl",
      "org.springframework.data.util.MethodInvocationRecorder$Recorded$ToMapConverter",
      "org.aspectj.lang.reflect.MemberSignature",
      "org.aspectj.lang.reflect.CatchClauseSignature",
      "org.springframework.beans.factory.wiring.BeanConfigurerSupport",
      "org.springframework.beans.factory.wiring.BeanWiringInfoResolver",
      "org.aspectj.runtime.reflect.SourceLocationImpl",
      "org.springframework.beans.factory.annotation.Configurable",
      "org.aspectj.lang.reflect.LockSignature",
      "org.springframework.web.bind.annotation.RequestMapping",
      "org.springframework.beans.factory.Aware",
      "org.springframework.stereotype.Controller",
      "org.springframework.http.ResponseEntity$BodyBuilder",
      "org.springframework.http.ReadOnlyHttpHeaders",
      "org.springframework.web.bind.annotation.CrossOrigin",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntrySet",
      "org.springframework.beans.factory.InitializingBean",
      "org.aspectj.runtime.reflect.SignatureImpl$Cache",
      "org.springframework.beans.factory.ObjectProvider",
      "org.springframework.http.ContentDisposition",
      "org.springframework.beans.factory.aspectj.AnnotationBeanConfigurerAspect",
      "org.aspectj.lang.reflect.CodeSignature",
      "org.springframework.beans.factory.aspectj.AbstractInterfaceDrivenDependencyInjectionAspect",
      "org.aspectj.lang.JoinPoint",
      "org.aspectj.runtime.reflect.JoinPointImpl$StaticPartImpl",
      "org.springframework.beans.FatalBeanException",
      "org.springframework.beans.factory.wiring.BeanWiringInfo",
      "org.springframework.web.bind.annotation.ResponseBody",
      "org.springframework.data.domain.Sort$Order",
      "org.aspectj.runtime.reflect.StringMaker",
      "org.springframework.http.InvalidMediaTypeException",
      "org.springframework.stereotype.Component",
      "org.springframework.beans.factory.NoSuchBeanDefinitionException",
      "org.springframework.http.ResponseEntity",
      "org.aspectj.lang.reflect.MethodSignature",
      "org.springframework.data.domain.Sort$TypedSort",
      "org.springframework.web.bind.annotation.Mapping",
      "org.springframework.util.Assert",
      "org.springframework.util.StringUtils"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("com.d365lab.eatery.restaurantcustomerorchestrator.services.CustomerOrchestratorService", false, CustomerOrchestratorController_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(CustomerOrchestratorController_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.d365lab.eatery.restaurantcustomerorchestrator.controllers.CustomerOrchestratorController",
      "org.springframework.web.bind.annotation.CrossOrigin",
      "org.springframework.web.bind.annotation.RequestMethod",
      "org.springframework.http.HttpStatus",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.CustomerAddress",
      "org.springframework.http.ReadOnlyHttpHeaders",
      "org.springframework.util.LinkedMultiValueMap",
      "org.springframework.util.Assert",
      "org.springframework.http.HttpHeaders",
      "org.springframework.util.LinkedCaseInsensitiveMap",
      "org.springframework.util.LinkedCaseInsensitiveMap$1",
      "org.springframework.util.CollectionUtils",
      "org.springframework.util.CollectionUtils$MultiValueMapAdapter",
      "org.springframework.http.HttpEntity",
      "org.springframework.http.ResponseEntity",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntrySet",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.CustomerInfo",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantCustomerMap",
      "org.springframework.data.domain.Unpaged",
      "org.springframework.data.domain.Chunk",
      "org.springframework.data.domain.PageImpl"
    );
  }
}