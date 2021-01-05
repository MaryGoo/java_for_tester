package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{
  @Test(enabled = false)
  public void testContactModification(){
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Casha",
              "by",
              "Lastname",
              "Cash",
              "Cashtitle",
              "MMTR",
              "street Shagova 180-5/1",
              "325525",
              "+7985656565",
              "csh@gmail.ru",
              "test4"),true);
    }
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().chooseEditContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size()- 1).getId(),
            "jhhjbggh",
            "lkj",
            "Lastname",
            "Cash",
            "Cashtitle",
            "MMTR",
            "street Shagova 180-5/1",
            "325525",
            "+7985656565",
            "csh@gmail.ru",
            null);
    app.getContactHelper().fillAddNewContact(contact,false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()- 1);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }
}
