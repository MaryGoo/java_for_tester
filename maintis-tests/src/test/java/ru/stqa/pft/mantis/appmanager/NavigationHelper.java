package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void manageUserPage() {
    click(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i"));
    click(By.linkText("Manage Users"));
    }
}

