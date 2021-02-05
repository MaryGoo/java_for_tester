package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test2"));

    }

    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("LiziFoGroup" ).withLastname("Smirnova" ).withNickname("red"), true);

    }

  }

  @Test
  public void testContactAddToGroup() {
    ContactData addContact = selectContact();
    GroupData toGroup = selectGroup(addContact);
    Groups before = addContact.getGroups();
    app.goTo().homePage();
    app.contact().addToGroup(addContact, toGroup);
    app.goTo().homePage();
    ContactData addContactAfter = selectContactById(addContact);
    Groups after = addContactAfter.getGroups();
    assertThat(after, equalTo(before.withAdded(toGroup)));


  }

  private ContactData selectContactById(ContactData addContact) {
    Contacts contactsById = app.db().contacts();
    return contactsById.iterator().next().withId(addContact.getId());
  }


  private ContactData selectContact() {
    Contacts allContacts = app.db().contacts();
    Groups allGroups = app.db().groups();
    for (ContactData contact : allContacts) {
      if (contact.getGroups().size() < allGroups.size()) {
        return contact;
      }
    }
    app.goTo().groupPage();
    app.group().create(new GroupData().withName("newGroupForAddContact"));
    return allContacts.iterator().next();
  }

  private GroupData selectGroup(ContactData addContact) {
    Groups allGroups = app.db().groups();
    Groups addContactGroups = addContact.getGroups();
    Collection<GroupData> contactGroups = new HashSet<GroupData>(addContactGroups);
    Collection<GroupData> different = new HashSet<GroupData>(allGroups);
    different.removeAll(contactGroups);
    GroupData differentGroup = different.iterator().next();
    return differentGroup;
  }
}
