package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Casha", "by", "Lastname", "Cash", "Cashtitle", "MMTR", "street Shagova 180-5/1", "325525", "+7985656565", "csh@gmail.ru","test4"),true);
    }
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().chooseContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlert();
  }
}
