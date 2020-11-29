package ru.stqa.pft.distance;

public class Distance {
  private static double dist;
  static double distance(Point p1, Point p2){
    return dist = Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
  }
}
