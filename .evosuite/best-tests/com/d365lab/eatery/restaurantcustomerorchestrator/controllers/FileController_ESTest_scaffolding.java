/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Mon Mar 09 09:00:41 GMT 2020
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
public class FileController_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.d365lab.eatery.restaurantcustomerorchestrator.controllers.FileController"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(FileController_ESTest_scaffolding.class.getClassLoader() ,
      "org.springframework.web.util.UriComponentsBuilder",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantMenuWithCustomization",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntrySetIterator",
      "org.springframework.beans.factory.annotation.Autowired",
      "org.springframework.core.io.ByteArrayResource",
      "org.springframework.core.io.WritableResource",
      "org.springframework.util.MimeType",
      "org.springframework.web.context.request.RequestContextHolder",
      "com.d365lab.eatery.restaurantcustomerorchestrator.property.FileStorageProperties",
      "org.springframework.web.util.HierarchicalUriComponents",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.Item",
      "org.springframework.core.io.Resource",
      "com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.RestaurantCustomerOrchestratorException",
      "org.springframework.util.MimeTypeUtils$ConcurrentLruCache",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntryIterator",
      "org.springframework.util.ClassUtils",
      "org.springframework.http.HttpHeaders",
      "org.springframework.http.ResponseEntity$DefaultBuilder",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.FileStorageService",
      "org.springframework.http.MediaType",
      "org.springframework.core.io.FileSystemResource",
      "org.springframework.web.bind.annotation.RequestMethod",
      "org.springframework.web.bind.annotation.RestController",
      "org.springframework.core.NamedThreadLocal",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantPaymentOptions",
      "org.springframework.http.HttpEntity",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantInfo",
      "org.springframework.util.CollectionUtils",
      "org.springframework.core.io.InputStreamSource",
      "org.springframework.http.ResponseEntity$HeadersBuilder",
      "org.springframework.web.util.OpaqueUriComponents",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantMenuInputPayload",
      "com.d365lab.eatery.restaurantcustomerorchestrator.dao.RestaurantMenuCustomization",
      "org.springframework.util.LinkedCaseInsensitiveMap",
      "org.springframework.core.io.ClassPathResource",
      "org.springframework.http.MediaType$1",
      "org.springframework.stereotype.Controller",
      "org.springframework.http.ResponseEntity$BodyBuilder",
      "org.springframework.http.ReadOnlyHttpHeaders",
      "org.springframework.web.bind.annotation.CrossOrigin",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntrySet",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.RestaurantDetails",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.FileStorageServiceImpl",
      "org.springframework.core.io.AbstractFileResolvingResource",
      "org.json.simple.parser.ParseException",
      "com.d365lab.eatery.restaurantcustomerorchestrator.model.UploadFileResponse",
      "org.springframework.stereotype.Service",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrchestratorService",
      "org.springframework.util.MimeType$SpecificityComparator",
      "org.springframework.core.io.VfsResource",
      "org.springframework.stereotype.Indexed",
      "org.springframework.lang.Nullable",
      "com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.FileNotFoundException",
      "com.d365lab.eatery.restaurantcustomerorchestrator.utils.exceptions.FileStorageException",
      "org.springframework.web.util.UriBuilder",
      "org.springframework.util.InvalidMimeTypeException",
      "org.springframework.core.io.VfsUtils",
      "org.springframework.web.servlet.support.ServletUriComponentsBuilder",
      "org.springframework.core.NamedInheritableThreadLocal",
      "org.springframework.util.MultiValueMap",
      "org.springframework.core.NestedIOException",
      "org.springframework.util.MimeTypeUtils",
      "org.springframework.web.bind.annotation.ResponseBody",
      "org.springframework.core.io.AbstractResource",
      "org.springframework.util.CollectionUtils$MultiValueMapAdapter",
      "org.springframework.util.LinkedCaseInsensitiveMap$1",
      "org.springframework.http.HttpStatus",
      "org.springframework.http.InvalidMediaTypeException",
      "org.springframework.stereotype.Component",
      "org.springframework.web.multipart.MultipartFile",
      "org.springframework.http.ResponseEntity",
      "com.d365lab.eatery.restaurantcustomerorchestrator.controllers.FileController",
      "org.springframework.util.LinkedMultiValueMap",
      "org.springframework.web.util.UriComponents",
      "org.springframework.util.Assert",
      "org.springframework.util.StringUtils"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("com.d365lab.eatery.restaurantcustomerorchestrator.services.RestaurantOrchestratorService", false, FileController_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.FileStorageServiceImpl", false, FileController_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("javax.servlet.ServletContext", false, FileController_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("javax.servlet.http.HttpServletRequest", false, FileController_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("org.springframework.web.multipart.MultipartFile", false, FileController_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(FileController_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.d365lab.eatery.restaurantcustomerorchestrator.controllers.FileController",
      "org.springframework.web.bind.annotation.CrossOrigin",
      "org.springframework.util.ClassUtils",
      "org.springframework.util.Assert",
      "org.springframework.core.NamedThreadLocal",
      "org.springframework.util.StringUtils",
      "org.springframework.core.NamedInheritableThreadLocal",
      "org.springframework.web.context.request.RequestContextHolder",
      "org.springframework.http.HttpStatus",
      "org.springframework.util.MimeType$SpecificityComparator",
      "org.springframework.util.MimeTypeUtils$ConcurrentLruCache",
      "org.springframework.util.MimeType",
      "org.springframework.util.CollectionUtils",
      "org.springframework.util.MimeTypeUtils",
      "org.springframework.core.io.AbstractResource",
      "org.springframework.core.io.FileSystemResource",
      "com.d365lab.eatery.restaurantcustomerorchestrator.services.impl.FileStorageServiceImpl",
      "org.springframework.core.io.VfsResource",
      "org.springframework.core.io.VfsUtils",
      "org.springframework.core.io.AbstractFileResolvingResource",
      "org.springframework.core.io.ClassPathResource",
      "org.springframework.http.ReadOnlyHttpHeaders",
      "org.springframework.util.LinkedMultiValueMap",
      "org.springframework.http.HttpHeaders",
      "org.springframework.util.LinkedCaseInsensitiveMap",
      "org.springframework.util.LinkedCaseInsensitiveMap$1",
      "org.springframework.util.CollectionUtils$MultiValueMapAdapter",
      "org.springframework.http.HttpEntity",
      "org.springframework.http.ResponseEntity",
      "org.springframework.http.ResponseEntity$DefaultBuilder",
      "org.springframework.http.MediaType$1",
      "org.springframework.http.MediaType",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntrySet",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntryIterator",
      "org.springframework.util.LinkedCaseInsensitiveMap$EntrySetIterator",
      "org.springframework.web.util.UriComponentsBuilder",
      "org.springframework.web.servlet.support.ServletUriComponentsBuilder",
      "org.springframework.util.InvalidMimeTypeException",
      "org.springframework.http.InvalidMediaTypeException",
      "org.springframework.core.io.UrlResource",
      "org.springframework.util.ResourceUtils",
      "com.d365lab.eatery.restaurantcustomerorchestrator.property.FileStorageProperties",
      "org.springframework.core.io.FileUrlResource",
      "org.springframework.core.io.ByteArrayResource"
    );
  }
}