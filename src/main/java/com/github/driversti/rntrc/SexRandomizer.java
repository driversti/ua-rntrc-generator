package com.github.driversti.rntrc;

import java.util.Random;

public class SexRandomizer {

  private final Random random;

  public SexRandomizer() {
    this.random = new Random();
  }

  public SexRandomizer(Random random) {
    this.random = random;
  }

  String sex() {
    final int minInclusive = 0;
    final int maxExclusive = 2;
    return String.valueOf(random.nextInt(maxExclusive - minInclusive) + minInclusive);
  }
}
