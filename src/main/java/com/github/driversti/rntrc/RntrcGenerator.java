package com.github.driversti.rntrc;

public class RntrcGenerator {

  private final BirthdayDaysGenerator birthdayDaysGenerator;
  private final PersonSerialNumberGenerator serialNumberGenerator;
  private final SexRandomizer sexRandomizer;
  private final ControlDigitCalculator controlDigitCalculator;

  public RntrcGenerator() {
    this.birthdayDaysGenerator = new BirthdayDaysGenerator();
    this.serialNumberGenerator = new PersonSerialNumberGenerator();
    this.sexRandomizer = new SexRandomizer();
    this.controlDigitCalculator = new ControlDigitCalculator();
  }

  public RntrcGenerator(BirthdayDaysGenerator birthdayDaysGenerator,
      PersonSerialNumberGenerator serialNumberGenerator, SexRandomizer sexRandomizer,
      ControlDigitCalculator controlDigitCalculator) {
    this.birthdayDaysGenerator = birthdayDaysGenerator;
    this.serialNumberGenerator = serialNumberGenerator;
    this.sexRandomizer = sexRandomizer;
    this.controlDigitCalculator = controlDigitCalculator;
  }

  public String rntrc() {
    final String days = birthdayDaysGenerator.days();
    final String serialNumber = serialNumberGenerator.serialNumber();
    final String sex = sexRandomizer.sex();
    final String first9Digits = days + serialNumber + sex;
    final String controlDigit = controlDigitCalculator.controlDigit(first9Digits);
    return first9Digits + controlDigit;
  }
}
