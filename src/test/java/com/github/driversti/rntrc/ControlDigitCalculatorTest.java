package com.github.driversti.rntrc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ControlDigitCalculatorTest {

  private final ControlDigitCalculator calculator = new ControlDigitCalculator();

  @ParameterizedTest
  @CsvSource(value = {"316621307:4", "224800033:1", "2164516600:0"}, delimiter = ':')
  void shouldCalculateControlDigit(String given, String expectedControlDigit) {
    // when
    final String actual = calculator.controlDigit(given);

    // then
    assertEquals(expectedControlDigit, actual);
  }
}
