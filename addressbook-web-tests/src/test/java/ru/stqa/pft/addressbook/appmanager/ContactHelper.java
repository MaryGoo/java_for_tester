package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void fillAddNewContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitAddContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void chooseContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void chooseEditContact(int index) {
    wd.findElements(By.xpath("//tr/td/a[contains(@href, 'edit.php?id')]")).get(index).click();
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public void goToAddNewPage() {
    click(By.linkText("add new"));
  }

  public void createContact(ContactData contact, boolean creation) {
    goToAddNewPage();
    fillAddNewContact(contact,true);
    submitAddContact();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("entry")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      ContactData contact = new ContactData(firstname, null,lastname,null,null,null,null,null,null,null,null);
      contacts.add(contact);
    }
    return contacts;
  }
}
