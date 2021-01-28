package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactAddToGroup extends TestBase {

  @BeforeMethod
  //check the precondition. the list of groups is obtained via the database
  public void ensurePreconditions() {
    if (app.db().groups().size() ==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test2"));
    }

    if (app.db().contacts().size() == 0){
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("LiziFoGroup").withLastname("Smirnova").withNickname("red"), true);
    }

  }

  @Test
  public void testContactAddToGroup (){
    Groups groups = app.db().groups(); //via the database
    GroupData groupTo = groups.iterator().next();
    Contacts before = app.db().contacts();
    ContactData addContact = before.iterator().next();
    for (int i = 0; i < before.size(); i++) {
      if (addContact.getGroups() == groups && i < before.size()) {
        addContact = before.iterator().next();
      } else {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("testElse"+i));
        i = before.size();
      }
    }
    app.goTo().homePage();
    app.contact().addToGroup(addContact, groupTo);
    app.goTo().homePage();
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
  }

}
