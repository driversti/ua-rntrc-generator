package com.github.driversti.rntrc;

import static java.lang.String.format;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.time.Month;

public class BirthdayDaysGenerator {

  private static final int DAYS_LENGTH = 5;
  private static final LocalDate MIN_DATE = LocalDate.of(1899, Month.DECEMBER, 31);

  private final LocalDateGenerator localDateGenerator;

  public BirthdayDaysGenerator() {
    this.localDateGenerator = new LocalDateGenerator();
  }

  public BirthdayDaysGenerator(LocalDateGenerator localDateGenerator) {
    this.localDateGenerator = localDateGenerator;
  }

  String days(final LocalDate birthday) {
    validateBirthday(birthday);
    final long days = DAYS.between(MIN_DATE, birthday);
    final String daysStr = String.valueOf(days);
    return withLeadingZeros(daysStr);
  }

  String days() {
    return days(localDateGenerator.random());
  }

  private void validateBirthday(LocalDate birthday) {
    if (birthday.isBefore(MIN_DATE)) {
      final String msg = format("%s should be after %s", birthday, MIN_DATE);
      throw new IllegalArgumentException(msg);
    }
  }

  private String withLeadingZeros(String daysStr) {
    if (daysStr.length() >= DAYS_LENGTH) {
      return daysStr;
    }
    StringBuilder result = new StringBuilder(daysStr);
    while (result.length() < DAYS_LENGTH) {
      result.insert(0, "0");
    }
    return result.toString();
  }
}
