package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;


public class TestBase {

  //Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME ));

  @BeforeSuite
  public void setUp() throws Exception {app.init();}

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws Exception {app.stop();}

  /*@BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("Start test " + m.getName() + " with parameters "+ Arrays.asList(p));
  }

  @AfterMethod (alwaysRun = true)
  public void logTestStop(Method m, Object[] p){
    logger.info("Stop test " + m.getName() + " with parameters "+ Arrays.asList(p));

  }

  public void verifyGroupListUI() {
    if (Boolean.getBoolean("verifyUI")) {  // -DverifyUI=true
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

   public void verifyContactListUI() {
    if (Boolean.getBoolean("verifyUI")) {  // -DverifyUI=true
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public ApplicationManager getApp() {return app;}*/
  
}
