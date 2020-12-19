package ru.stqa.pft.sandbox;

public class PrimesWhile {

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n && n % i == 0) {
      i ++;
    }
    return i == n;
  }
}
