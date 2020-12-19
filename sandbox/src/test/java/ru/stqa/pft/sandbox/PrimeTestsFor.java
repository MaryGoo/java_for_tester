package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTestsFor {

  @Test
  public void testPrime (){
    Assert.assertTrue(PrimesFor.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrime (){
    Assert.assertFalse(PrimesFor.isPrime(Integer.MAX_VALUE-2));
  }
}