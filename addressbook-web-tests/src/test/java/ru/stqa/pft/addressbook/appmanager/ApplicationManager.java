package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  public WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper helperGroup ;

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
    sessionHelper.wd =new ChromeDriver();
    sessionHelper.wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    sessionHelper.wd.get("http://localhost/addressbook/");
    helperGroup = new GroupHelper(sessionHelper.wd);
    navigationHelper = new NavigationHelper(sessionHelper.wd);
    sessionHelper = new SessionHelper()
    sessionHelper.login("admin", "secret");
  }

  public boolean isElementPresent(By by) {
    try {
      sessionHelper.wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      sessionHelper.wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public GroupHelper getHelperGroup() {
    return helperGroup;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
