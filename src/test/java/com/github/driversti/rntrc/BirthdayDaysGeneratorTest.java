package com.github.driversti.rntrc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BirthdayDaysGeneratorTest {

  private final BirthdayDaysGenerator daysGenerator = new BirthdayDaysGenerator();

  @ParameterizedTest
  @CsvSource(value = {"1900-01-01:00001", "1900-12-12:00346", "1986-09-08:31662"}, delimiter = ':')
  void shouldAddLeadingZerosWhenNecessary(String givenDate, String expected) {
    // given
    final LocalDate birthday = LocalDate.parse(givenDate);

    //when
    final String days = daysGenerator.days(birthday);

    // then
    assertEquals(expected, days);
  }
}
