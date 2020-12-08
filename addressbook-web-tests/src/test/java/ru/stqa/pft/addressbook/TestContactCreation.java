package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class TestContactCreation {
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String usename, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(usename);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreation() throws Exception {
    goToNewAddressbook();
    fillFormForNewAddressbook(new FormForNewAddressbookName("maryghhs", "mfghix", "ghsfghoo", "marsfhyGoo", "titleMshhsary"));
    fillCompany(new FormCompany("sfdhsfgh", "HGJHGJshfhfhg 154/8", "353535", "8989885454"));
    fillFormEmail(new FormMail("hfjk1111g@fgh.ru", "email"));
    fillFormEmail(new FormMail("hfjkg11122@fgh.ru", "email2"));
    fillFormEmail(new FormMail("hfjkg111133@fgh.ru", "email3"));
    fillFormHomePage(new FormHomePage("kgh111kgjh.ru"));
    fillDate(new FormDate("a", "5", "March", "2000"));
    fillDate(new FormDate("b", "10", "March", "2020"));
    fillGroup(new FormGroupByAddNew("test3"));
    submitAddNewContact();
    goToHomePage();
    logout();
  }



  private void goToNewAddressbook() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void fillFormForNewAddressbook(FormForNewAddressbookName formForNewAddressbookName) {
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(formForNewAddressbookName.getFirstname());
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(formForNewAddressbookName.getMiddlename());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(formForNewAddressbookName.getLastname());
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(formForNewAddressbookName.getNickname());
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(formForNewAddressbookName.getTitle());
  }
  private void fillCompany(FormCompany formCompany){
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(formCompany.getCompany());
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(formCompany.getAddress());
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(formCompany.getHomePhone());
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(formCompany.getMobilePhone());
  }
    private void fillFormEmail(FormMail formMail) {
      wd.findElement(By.name(formMail.getMailNumber())).clear();
      wd.findElement(By.name(formMail.getMailNumber())).sendKeys(formMail.getMailValue());
    }
  private void fillFormHomePage(FormHomePage formHomePage){
      wd.findElement(By.name("homepage")).clear();
      wd.findElement(By.name("homepage")).sendKeys(formHomePage.getNameHomePage());
    }
     private void fillDate(FormDate formDate) {
      new Select(wd.findElement(By.name(formDate.getGroupDate() +"day"))).selectByVisibleText(formDate.getDay());
      new Select(wd.findElement(By.name(formDate.getGroupDate() +"month"))).selectByVisibleText(formDate.getMonth());
      wd.findElement(By.name(formDate.getGroupDate() +"year")).clear();
      wd.findElement(By.name(formDate.getGroupDate() +"year")).sendKeys(formDate.getYear());
    }
  private void fillGroup(FormGroupByAddNew formGroupByAddNew) {
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(formGroupByAddNew.getNameGroup());
  }

  private void submitAddNewContact(){
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void goToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
