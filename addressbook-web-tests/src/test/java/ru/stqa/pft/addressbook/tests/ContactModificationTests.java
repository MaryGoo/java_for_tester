package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().chooseEditContact();
    app.getContactHelper().fillAddNewContact(new ContactData("+7989-87-87-87","25-65-65"));
    app.getContactHelper().updateContact();
    app.getNavigationHelper().goToHomePage();
  }
}
