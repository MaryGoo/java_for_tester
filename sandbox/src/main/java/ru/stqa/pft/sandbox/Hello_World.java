package ru.stqa.pft.sandbox;

public class Hello_World {
	public static void main(String[] args) {
		hello("Word");
		hello("Mary");

		double l = 5;
    System.out.println("Площадь квдрата =" + area(l));

    double a = 1;
    double b = 3;
    System.out.println("Площадь прямоугольника =" + area(a, b));

	}
	public static void hello(String some) {
    System.out.println("Hello, " + some + "!");
  }

  public static double area (double lkv) {
	  return lkv * lkv;
  }
  public static double area (double a, double b) {
    return a * b;
  }
}