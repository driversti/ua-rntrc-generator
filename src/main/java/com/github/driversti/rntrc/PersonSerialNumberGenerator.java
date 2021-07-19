package com.github.driversti.rntrc;

import java.util.Random;

public class PersonSerialNumberGenerator {

  private static final int LENGTH = 3;

  private final Random random;

  public PersonSerialNumberGenerator() {
    this.random = new Random();
  }

  public PersonSerialNumberGenerator(Random random) {
    this.random = random;
  }

  String serialNumber() {
    final int min = 0;
    final int max = 999;
    final String serialNumber = String.valueOf(random.nextInt(max - min) + min);
    return withLeadingZeros(serialNumber);
  }

  private String withLeadingZeros(String serialNumber) {
    if (serialNumber.length() >= LENGTH) {
      return serialNumber;
    }
    StringBuilder result = new StringBuilder(serialNumber);
    while (result.length() < LENGTH) {
      result.insert(0, "0");
    }
    return result.toString();
  }
}
