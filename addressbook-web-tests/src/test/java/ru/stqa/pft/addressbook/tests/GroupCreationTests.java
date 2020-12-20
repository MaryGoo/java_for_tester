package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupDataNew;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    List<GroupDataNew> before = app.getGroupHelper().getGroupList();
    GroupDataNew group = new GroupDataNew("test4", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupDataNew> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), (before.size() + 1));

    int max = 0;
    for (GroupDataNew g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    group.setId (max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
