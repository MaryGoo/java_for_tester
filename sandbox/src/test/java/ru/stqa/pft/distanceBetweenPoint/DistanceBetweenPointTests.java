package ru.stqa.pft.distanceBetweenPoint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceBetweenPointTests {
  @Test
  public void testDistanceBetweenPoint0() {
    Point p1 = new Point(4,4);
    Point p2 = new Point(4,4);
    Assert.assertEquals(Distance.distance(p1,p2), 0);
  }

  @Test
  public void testDistanceBetweenPoint1() {
    Point p1 = new Point(4,4);
    Point p2 = new Point(1,1);
    double expectedResult = Math.round((3 * Math.sqrt(2))*100.0) / 100.0;
    double actualResult = Math.round (Distance.distance(p1,p2) * 100.0) / 100.0;
    Assert.assertEquals(actualResult, expectedResult);
  }
  @Test
  public void testDistanceBetweenPoint2() {
    Point p1 = new Point(0,4);
    Point p2 = new Point(2,0);
    double expectedResult = Math.round((2 * Math.sqrt(5))*100.0) / 100.0;
    double actualResult = Math.round (Distance.distance(p1,p2) * 100.0) / 100.0;
    Assert.assertEquals(actualResult, expectedResult);
  }
}
