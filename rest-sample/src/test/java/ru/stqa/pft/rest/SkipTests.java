package ru.stqa.pft.rest;

import org.testng.annotations.Test;

public class SkipTests extends TestBase{

  @Test
  public void testSkip()  {
    int issueId = 1;
    skipIfNotFixed(issueId);
    System.out.println("NOT Ignored because of issue " + issueId);
  }
}
