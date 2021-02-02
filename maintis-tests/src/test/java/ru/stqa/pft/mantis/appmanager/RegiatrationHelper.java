package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

public class RegiatrationHelper {
  private final ApplicationManager app;
  private WebDriver wd;

  public RegiatrationHelper(ApplicationManager app) {
    this.app = app;
    wd = app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("wed.baseUrl" /*+ "/signup_page.php"*/));
  }
}
