package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class ChangingUserPassword extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangingUserPassword() throws IOException, MessagingException {
    Users before = app.db().users();
    before.removeIf(elem -> elem.getUsername().equals("administrator"));
    if (before.size() == 0) {
      return;
    }
    UserData modifyUser = before.iterator().next();
    System.out.println(before);
    System.out.println(modifyUser);
    long time = System.currentTimeMillis();
    String realName = String.format("realName%s",time);
    String password = "password";
    String email = modifyUser.getEmail();
    String user = modifyUser.getUsername();
    app.session().loginUI("administrator", "root");
    app.goTo().manageUserPage();
    app.user().selectUser(modifyUser.getId());
    app.user().resetPassword();
    app.session().logout();

    List<MailMessage> mailMessages =  app.mail().waitForMail(1, 10000);
    String confirmationLink= findConfirmationLink (mailMessages, email);
    app.registration().finish(confirmationLink, password, realName);
    assertTrue(app.newSession().login(user, password));
  }


  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }

}


