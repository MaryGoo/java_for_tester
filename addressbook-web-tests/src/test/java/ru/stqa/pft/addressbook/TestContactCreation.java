package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class TestContactCreation {
  private WebDriver wd;


  @BeforeClass(alwaysRun = true)
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
  public void testOntactCreation() throws Exception {
    goToNewAddressbook();
    fillFormForNewAddressbook(new FormForNewAddressbookName("mary", "mix", "goo", "maryGoo", "titleMary"));
    fillCompany(new FormCompany("MMTR", "HGJHGJg 154/8", "353535", "8989885454"));
    fillFormEmail();
    fillDate();
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
    private void fillFormEmail() {
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys("hfjkg@fgh.ru");
      wd.findElement(By.name("email2")).clear();
      wd.findElement(By.name("email2")).sendKeys("hfjkg22@fgh.ru");
      wd.findElement(By.name("email3")).clear();
      wd.findElement(By.name("email3")).sendKeys("hfjkg33@fgh.ru");
      wd.findElement(By.name("homepage")).clear();
      wd.findElement(By.name("homepage")).sendKeys("kghkgjh.ru");
    }
  private void fillDate(){
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText("1");
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("January");
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys("2000");
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText("3");
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText("March");
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys("2020");
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText("test3");
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys("fkjghkfjgh");
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys("22-2");
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys("gjgh srtjhsth arthsh");
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void goToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterClass(alwaysRun = true)
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
