package ru.stqa.pft.distanceBetweenPoint;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DistanceBetweenPointTests {
  @Test
  public void testDistanceBetweenPoint0() {
    Point p1 = new Point(4,4);
    Point p2 = new Point(4,4);
    assertEquals(Distance.distance(p1,p2), 0);
  }

  @Test
  public void testDistanceBetweenPoint1() {
    Point p1 = new Point(4,4);
    Point p2 = new Point(1,1);
    double expectedResult = 3 * Math.sqrt(2);
    double actualResult = Distance.distance(p1,p2);
    assertEquals(expectedResult, actualResult, 0.001);
  }
  @Test
  public void testDistanceBetweenPoint2() {
    Point p1 = new Point(0,4);
    Point p2 = new Point(2,0);
    double expectedResult = (2 * Math.sqrt(5));
    double actualResult = Distance.distance(p1,p2);
    assertEquals(expectedResult, actualResult, 0.001);
  }
  @Test
  public void testDistanceBetweenPoint3() {
    Point p1 = new Point(-4,-4);
    Point p2 = new Point(-2,0);
    double expectedResult = (2 * Math.sqrt(5));
    double actualResult = Distance.distance(p1,p2);
    assertEquals(expectedResult, actualResult, 0.001);
  }
}
