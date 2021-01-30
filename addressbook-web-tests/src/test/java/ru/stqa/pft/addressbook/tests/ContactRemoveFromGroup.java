package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    ContactData removeContact = selectContact();
    GroupData fromGroup = selectGroup(removeContact);
    Groups addContactGroupsAfter = removeContact.getGroups();
    app.goTo().homePage();
    app.contact().removeFromGroup(removeContact, fromGroup);
    app.goTo().homePage();
    Groups addContactGroupsBefore = removeContact.getGroups();
    addContactGroupsBefore.remove(fromGroup);
    assertThat(addContactGroupsAfter, equalTo(addContactGroupsBefore));

  }/*
     Contacts allContacts = app.db().contacts();
    Groups allGroups = app.db().groups();
    for (ContactData contact : allContacts) {
      if (contact.getGroups().size() < allGroups.size()) {
        return contact;
      }
    }
    app.goTo().groupPage();
    app.group().create(new GroupData().withName("newGroupForAddContact"));
    return allContacts.iterator().next();*/

  private ContactData selectContact() {
    Contacts allContacts = app.db().contacts();
    //Groups addContactGroups = addContact.getGroups();
    //Groups allGroups = app.db().groups();
    for (ContactData contact : allContacts) {
      if (contact.getGroups().size() > 0) {
        return contact;
      }
    }
    //app.goTo().groupPage();
    ContactData addContact = app.db().contacts().iterator().next();
    //GroupData toGroup = app.db().groups().iterator().next();
    app.contact().addToGroup(addContact, app.db().groups().iterator().next());
    return  addContact;
  }

  private GroupData selectGroup(ContactData removeContact) {
    Groups removeContactGroups = removeContact.getGroups();
    return removeContactGroups.iterator().next();
  }
}
