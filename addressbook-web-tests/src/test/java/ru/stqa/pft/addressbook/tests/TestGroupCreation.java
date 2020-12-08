package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDataNew;

public class TestGroupCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getHelperGroup().returnGroupPage();
    app.getHelperGroup().initGroupCreation();
    app.getHelperGroup().fillGroupForm(new GroupDataNew("test4", "test444", "test4444"));
    app.getHelperGroup().submitGroupCreation();
    app.getHelperGroup().returnGroupPage();
  }

}
