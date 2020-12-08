package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class TestGroupDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    goToGroupPage();
    selectGroup();
    deleteSelectGroups();
    returnGroupPage();
  }

}
