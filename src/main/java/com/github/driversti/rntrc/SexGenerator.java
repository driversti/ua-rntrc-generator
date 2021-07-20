package com.github.driversti.rntrc;

import java.util.Random;

public class SexGenerator {

  private final Random random;

  public SexGenerator() {
    this.random = new Random();
  }

  public SexGenerator(Random random) {
    this.random = random;
  }

  String sex() {
    final int minInclusive = 0;
    final int maxExclusive = 9;
    return String.valueOf(random.nextInt(maxExclusive - minInclusive) + minInclusive);
  }
}
