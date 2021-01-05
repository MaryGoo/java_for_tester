package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @Test(enabled = false)
  public void testContactDeletion() {
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
    app.getContactHelper().chooseContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlert();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }
}
