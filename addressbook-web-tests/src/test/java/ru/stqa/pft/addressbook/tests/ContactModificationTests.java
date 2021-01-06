package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Lizi").withLastname("Smirnova").withNickname("red").withGroup("test3"), true);
    }
  }

  @Test
  public void testContactModification(){
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifyContact.getId()).withFirstname("Anna").withLastname("Orlova").withNickname("crazy").withGroup("test254")
            .withAddress("street Shagova 180-5/1").withEmail("csh@gmail.ru").withWorkPhone("+7985656565");
    app.contact().modify(contact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifyContact);
    before.add(contact);
    Assert.assertEquals(before,after);
  }
}
