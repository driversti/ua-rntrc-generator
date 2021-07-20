package com.github.driversti.rntrc;

public class RntrcGenerator {

  private final BirthdayDaysGenerator birthdayDaysGenerator;
  private final PersonSerialNumberGenerator serialNumberGenerator;
  private final SexGenerator sexGenerator;
  private final ControlDigitCalculator controlDigitCalculator;

  public RntrcGenerator() {
    this.birthdayDaysGenerator = new BirthdayDaysGenerator();
    this.serialNumberGenerator = new PersonSerialNumberGenerator();
    this.sexGenerator = new SexGenerator();
    this.controlDigitCalculator = new ControlDigitCalculator();
  }

  public RntrcGenerator(BirthdayDaysGenerator birthdayDaysGenerator,
      PersonSerialNumberGenerator serialNumberGenerator, SexGenerator sexGenerator,
      ControlDigitCalculator controlDigitCalculator) {
    this.birthdayDaysGenerator = birthdayDaysGenerator;
    this.serialNumberGenerator = serialNumberGenerator;
    this.sexGenerator = sexGenerator;
    this.controlDigitCalculator = controlDigitCalculator;
  }

  public String rntrc() {
    final String days = birthdayDaysGenerator.days();
    final String serialNumber = serialNumberGenerator.serialNumber();
    final String sex = sexGenerator.sex();
    final String first9Digits = days + serialNumber + sex;
    final String controlDigit = controlDigitCalculator.controlDigit(first9Digits);
    return first9Digits + controlDigit;
  }
}
