package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataNew;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    List<GroupDataNew> before = app.getGroupHelper().getGroupList();
    GroupDataNew group = new GroupDataNew("test2", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupDataNew> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), (before.size() + 1));

    int max = 0;
    for (GroupDataNew g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    //Comparator<? super GroupDataNew> byId =  (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    //int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    group.setId (after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupDataNew> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
