package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

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
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    //attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void fillModifyContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void submitAddContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void choose(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void chooseById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void chooseEditContact(int index) {
    wd.findElements(By.xpath("//tr/td/a[contains(@href, 'edit.php?id')]")).get(index).click();
  }

  private void chooseEditContactById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    //wd.findElement(By.xpath(String.format("a[href='edit.php?id=%s']",id)));
    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id)));
    //wd.findElement(By.xpath(String.format("tr[.//input[@value='%s']]/td[8]/a",id)));
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  public void modify(ContactData contact) {
    chooseEditContactById(contact.getId());
    fillModifyContact(contact, false);
    updateContact();
    contactCache = null;
  }

  public void delete() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void addTo() {
    click(By.name("add"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public void goToAddNewPage() {
    click(By.linkText("add new"));
  }

  public void create(ContactData contact, boolean creation) {
    goToAddNewPage();
    fillAddNewContact(contact, true);
    submitAddContact();
    contactCache = null;
  }

  public void delete(int index) {
    choose(index);
    delete();
    closeAlert();
  }

  public void delete(ContactData contact) {
    chooseById(contact.getId());
    delete();
    closeAlert();
    contactCache = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("entry")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
      contacts.add(contact);
    }
    return contacts;
  }

  private Contacts contactCache = null;

    /*public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            String[] phones = element.findElement(By.xpath(".//td[6]")).getText().split("\n");
            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }*/

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      ContactData contact = new ContactData()
              .withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    ;
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    ;
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    ;
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    ;
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    wd.navigate().back();
    return new ContactData().withFirstname(firstname).withMiddlename(middlename).withLastname(lastname)
            .withHomePhone(homePhone).withWorkPhone(workPhone).withMobilePhone(mobilePhone)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  public void addToGroup(ContactData addContact, GroupData groupTo) {
    chooseById(addContact.getId());
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(groupTo.getName());
    addTo();
  }

  public void removeFromGroup(ContactData removeContact, GroupData fromGroup) {
    new Select(wd.findElement(By.name("group"))).selectByVisibleText(fromGroup.getName());
    chooseById(removeContact.getId());
    click(By.name("remove"));
  }
}
