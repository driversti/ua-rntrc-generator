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

import java.util.Random;

public class RntrcGeneratorFactory {

  private final static Random random = new Random();

  // todo make it as a singleton
  public static RntrcGenerator create() {
    LocalDateGenerator localDateGenerator = new LocalDateGenerator(random);
    DaysToBirthdayGenerator bDaysGenerator = new DaysToBirthdayGenerator(localDateGenerator);
    PersonSerialNumberGenerator personSNGenerator = new PersonSerialNumberGenerator(random);
    SexGenerator sexGenerator = new SexGenerator(random);
    ControlDigitCalculator controlDigitCalculator = new ControlDigitCalculator();

    return new RntrcGenerator(bDaysGenerator, personSNGenerator, sexGenerator,
        controlDigitCalculator);
  }
}
