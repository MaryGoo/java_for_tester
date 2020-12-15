package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().chooseEditContact();
    app.getContactHelper().fillAddNewContact(new ContactData("jhhjbggh", "lkj",
            "Lastname", "Cash", "Cashtitle", "MMTR", "street Shagova 180-5/1",
            "325525", "+7985656565", "csh@gmail.ru", null),false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().goToHomePage();
  }
}
