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

  private final DaysToBirthdayGenerator daysToBirthdayGenerator;
  private final PersonSerialNumberGenerator serialNumberGenerator;
  private final SexGenerator sexGenerator;
  private final ControlDigitCalculator controlDigitCalculator;

  RntrcGenerator(DaysToBirthdayGenerator daysToBirthdayGenerator,
      PersonSerialNumberGenerator serialNumberGenerator, SexGenerator sexGenerator,
      ControlDigitCalculator controlDigitCalculator) {
    this.daysToBirthdayGenerator = daysToBirthdayGenerator;
    this.serialNumberGenerator = serialNumberGenerator;
    this.sexGenerator = sexGenerator;
    this.controlDigitCalculator = controlDigitCalculator;
  }

  public String random() {
    final String daysToBirthday = daysToBirthdayGenerator.random();
    return withControlDigit(withSex(withSN(daysToBirthday)));
  }

  private String withSN(String daysToBirthday) {
    final String serialNumber = serialNumberGenerator.random();
    return daysToBirthday + serialNumber;
  }

  private String withSex(String daysAndSN) {
    final String sex = sexGenerator.random();
    return daysAndSN + sex;
  }

  private String withControlDigit(String first9digits) {
    final String controlDigit = controlDigitCalculator.controlDigit(first9digits);
    return first9digits + controlDigit;
  }
}
