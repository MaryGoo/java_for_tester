package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EguationTests {

  @Test
  public void test0 () {
    Eguation e = new Eguation(1,1,1);
    Assert.assertEquals(e.rootNumber(),0);
  }

  @Test
  public void test1 () {
    Eguation e = new Eguation(1,2,1);
    Assert.assertEquals(e.rootNumber(),1);
  }

  @Test
  public void test2 () {
    Eguation e = new Eguation(1,5,6);
    Assert.assertEquals(e.rootNumber(),2);
  }

  @Test
  public void testLinear () {
    Eguation e = new Eguation(0,5,6);
    Assert.assertEquals(e.rootNumber(),1);
  }

  @Test
  public void testConstanta () {
    Eguation e = new Eguation(0,0,6);
    Assert.assertEquals(e.rootNumber(),0);
  }

  @Test
  public void testZero () {
    Eguation e = new Eguation(0,0,0);
    Assert.assertEquals(e.rootNumber(),-1);
  }
}
