package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class TestGroupDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getHelperGroup().selectGroup();
    app.getHelperGroup().deleteSelectGroups();
    app.getHelperGroup().returnGroupPage();
  }

}
