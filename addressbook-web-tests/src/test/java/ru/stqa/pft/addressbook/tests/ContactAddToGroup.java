package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

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
  public ContactData testContactAddToGroup (){
    ContactData addContact = selectContact();
    GroupData groupTo = selectGroup(addContact);
    app.goTo().homePage();
    app.contact().addToGroup(addContact, groupTo);
    app.goTo().homePage();
    //Contacts after = app.db().contacts();
    //assertThat(after, equalTo(co));
    return null;
  }

   private ContactData selectContact() {
     Contacts allContacts = app.db().contacts();
     Groups allGroups = app.db().groups();
     for (ContactData contact : allContacts) {
       if (contact.getGroups().size() < allGroups.size()) {
         return contact;
       }
     }
     app.goTo().homePage();
     ContactData contact = new ContactData().withFirstname("LiziFoGroup").withLastname("Smirnova").withNickname("red");
     app.contact().create(contact,true);
     Contacts newAllContacts = app.db().contacts();
     return contact.withId(newAllContacts.stream().mapToInt((c) -> c.getId()).max().getAsInt());
   }

     private GroupData selectGroup(ContactData addContact) {
       Groups allGroups = app.db().groups();
       Groups contactGroups = addContact.getGroups();
       for (GroupData group : contactGroups) {
         allGroups.remove(group);
       }
       return allGroups.iterator().next();
       }
  }
