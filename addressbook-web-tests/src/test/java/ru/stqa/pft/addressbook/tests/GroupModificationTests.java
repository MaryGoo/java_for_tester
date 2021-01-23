package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase{

  /*@BeforeMethod         check the precondition. the list of groups is obtained via the web interface
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test2"));
    }
  }*/

  @BeforeMethod
  //check the precondition. the list of groups is obtained via the database
  public void ensurePreconditions() {
    if (app.db().groups().size() ==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test2"));
    }
  }


  @Test
  public void testGroupModification(){
    //Groups before = app.group().all(); via the web interface
    Groups before = app.db().groups(); //via the database
    GroupData modifyGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifyGroup.getId()).withName("test25").withFooter("text").withHeader("text2");
    app.goTo().groupPage();
    app.group().modify(group); // main action in the test
    assertThat(app.group().count(), equalTo(before.size())); //this check is slow. but. it controls the user interface minimally
    //Groups after = app.group().all(); via the web interface
    Groups after = app.db().groups(); //via the database
    assertThat(after, equalTo(before.without(modifyGroup).withAdded(group)));
  }
}
