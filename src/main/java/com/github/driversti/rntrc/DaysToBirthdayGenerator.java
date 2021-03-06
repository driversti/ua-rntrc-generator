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

import static java.lang.String.format;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.time.Month;

class DaysToBirthdayGenerator {

  private static final int DAYS_LENGTH = 5;
  private static final LocalDate MIN_DATE = LocalDate.of(1899, Month.DECEMBER, 31);

  private final LocalDateGenerator localDateGenerator;

  DaysToBirthdayGenerator(LocalDateGenerator localDateGenerator) {
    this.localDateGenerator = localDateGenerator;
  }

  String random() {
    return bornOn(localDateGenerator.random());
  }

  String bornOn(final LocalDate birthday) {
    validateBirthday(birthday);
    final long days = DAYS.between(MIN_DATE, birthday);
    final String daysStr = String.valueOf(days);
    return withLeadingZeros(daysStr);
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
