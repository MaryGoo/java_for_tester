package ru.stqa.pft.sandbox;

public class MyFirstProgramme {
	public static void main(String[] args) {
		Square s = new Square(5);
		System.out.println(s.l);
    System.out.println(s.area());

    Rectangle r = new Rectangle(1.2,3);
    System.out.println(r.area());
	}
}