package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDataNew;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    List<GroupDataNew> before = app.getGroupHelper().getGroupList();
//    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupDataNew("test4", null, null));
//    int after = app.getGroupHelper().getGroupCount();
    List<GroupDataNew> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), (before.size() + 1));
  }

}
