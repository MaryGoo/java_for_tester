package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    /*app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Lizi").withLastname("Smirnova").withNickname("red").withGroup("test3"), true);
    }*/
    if (app.db().contacts().size() == 0){
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("Lizi").withLastname("Smirnova").withNickname("red")/*.withGroup("test3")*/, true);
    }
  }

  @Test
  public void testContactModification(){
    //Contacts before = app.contact().all();
    Contacts before = app.db().contacts();
    app.goTo().homePage();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifyContact.getId()).withFirstname("Anna").withMiddlename("").withLastname("Orlova").withNickname("crazy")
            .withTitle("").withCompany("NAME")
            .withAddress("street Shagova 180-5/1").withEmail("csh@gmail.ru").withEmail2("c222sh@gmail.ru").withEmail3("cs333h@gmail.ru")
            .withWorkPhone("+7985656565").withHomePhone("654676545").withMobilePhone("11111111")
            //.withGroup("test254")
            ;
    app.contact().modify(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
  }
}
