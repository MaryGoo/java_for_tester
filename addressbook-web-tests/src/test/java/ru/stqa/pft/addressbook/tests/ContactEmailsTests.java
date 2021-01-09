package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Lizi").withLastname("Smirnova").withNickname("red").withWorkPhone("145236").withHomePhone("654647454").withMobilePhone("987545464")
                    .withGroup("test3").withEmail("jhgflhf@dkj").withEmail2("fjjljf@jfff").withEmail3("lkdfj@hh"), true);
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm (contact);
        assertThat(contact.getAllEmails(), equalTo(mergeEmail(contactInfoFromEditForm)));
    }

    private String  mergeEmail(ContactData contact) {
        return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhonesTests ::cleaned)
                .collect(Collectors.joining("\n"));
    }
}

