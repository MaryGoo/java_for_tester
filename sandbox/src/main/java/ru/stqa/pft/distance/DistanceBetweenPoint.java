package ru.stqa.pft.distance;

public class DistanceBetweenPoint {
  public static void main(String[] args) {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(5, 7);
    System.out.println(Distance.distance(p1,p2));
   }
}
