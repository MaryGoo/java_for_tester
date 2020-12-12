package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class TestContactCreation extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToAddNewPage();
    app.getContactHelper().fillAddNewForm(new ContactData("Casha", "by", "Lastname", "Cash", "Cashtitle", "MMTR", "street Shagova 180-5/1", "325525", "+7985656565", "csh@gmail.ru"));
    app.getContactHelper().submitAddNew();
    app.getNavigationHelper().goToHomePage();
  }
}
