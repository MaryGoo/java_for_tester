package ru.stqa.pft.distanceBetweenPoint;

public class Point {
  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point p) {
    double dist = Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));
    return dist;
  }
}