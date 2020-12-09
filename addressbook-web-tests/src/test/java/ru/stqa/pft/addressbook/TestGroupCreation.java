package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class TestGroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    returnGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupDataNew("test4", "test444", "test4444"));
    submitGroupCreation();
    returnGroupPage();
  }

}
