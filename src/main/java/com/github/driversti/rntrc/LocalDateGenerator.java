package com.github.driversti.rntrc;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Random;

class LocalDateGenerator {

  private static final Random random = new Random();

  LocalDate random() {
    final int year = randomYear();
    final int month = randomMonth();
    final int day = randomDay(year, month);
    return LocalDate.of(year, month, day);
  }

  private int randomYear() {
    final int min = 1899;
    final int max = LocalDate.now().getYear();
    return randomNumber(min, max);
  }

  private int randomMonth() {
    final int min = 1;
    final int max = 12;
    return randomNumber(min, max);
  }

  private int randomDay(int year, int month) {
    final int min = 1;
    final Month m = Month.of(month);
    final int max = Year.isLeap(year) ? m.maxLength() : m.minLength();
    return randomNumber(min, max);
  }

  private int randomNumber(final int min, final int max) {
    return random.nextInt(max - min) + min;
  }
}
