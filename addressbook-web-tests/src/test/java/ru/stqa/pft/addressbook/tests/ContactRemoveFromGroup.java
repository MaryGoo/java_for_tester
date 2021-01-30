package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactRemoveFromGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0){
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("LiziFoGroup").withLastname("Smirnova").withNickname("red"), true);
      ContactData addContact = app.db().contacts().iterator().next();
      GroupData toGroup = app.db().groups().iterator().next();
      app.contact().addToGroup(addContact, toGroup);
    }
    if (app.db().groups().size() ==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test2"));
      ContactData addContact = app.db().contacts().iterator().next();
      GroupData toGroup = app.db().groups().iterator().next();
      app.contact().addToGroup(addContact, toGroup);
    }

  }

  @Test
  public void testContactRemoveFromGroup () {


  }
}
