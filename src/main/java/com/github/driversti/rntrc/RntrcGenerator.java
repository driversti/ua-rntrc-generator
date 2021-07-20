//   Copyright 2021 Yurii Chekhotskyi aka driversti
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       https://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

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
