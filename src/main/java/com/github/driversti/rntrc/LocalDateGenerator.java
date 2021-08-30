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

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Random;

class LocalDateGenerator {

  private final Random random;

  LocalDateGenerator(Random random) {
    this.random = random;
  }

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
