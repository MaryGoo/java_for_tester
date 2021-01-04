package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification(){
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Casha", "by", "Lastname", "Cash", "Cashtitle", "MMTR", "street Shagova 180-5/1", "325525", "+7985656565", "csh@gmail.ru","test4"),true);
    }
    app.getNavigationHelper().goToHomePage();
    //int before = app.getContactHelper().getContactCount();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().chooseEditContact(before.size() - 1);
    app.getContactHelper().fillAddNewContact(new ContactData("jhhjbggh",
            "lkj",
            "Lastname",
            "Cash",
            "Cashtitle",
            "MMTR",
            "street Shagova 180-5/1",
            "325525",
            "+7985656565",
            "csh@gmail.ru",
            null),false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().goToHomePage();
    //int after = app.getContactHelper().getContactCount();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
