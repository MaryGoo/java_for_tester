package ru.stqa.pft.distanceBetweenPoint;

public class Point {
  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  double distance(double x, double y) {
    double dist = Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));
    return dist;
  }

  double distance(Point p){
    return distance(p.x, p.y);
  }
}