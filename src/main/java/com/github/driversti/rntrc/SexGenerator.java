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

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

class SexGenerator {

  private static final String[] MALE_VALUES = new String[]{"1", "3", "5", "7", "9"};
  private static final String[] FEMALE_VALUES = new String[]{"0", "2", "4", "6", "8"};
  private static final String[] ALL_VALUES = initAllValues();

  private final Random random;

  public SexGenerator(Random random) {
    this.random = random;
  }

  private static String[] initAllValues() {
    return Stream.concat(Arrays.stream(FEMALE_VALUES), Arrays.stream(MALE_VALUES))
        .sorted().toArray(String[]::new);
  }

  String random() {
    final int index = randomValue(ALL_VALUES.length);
    return ALL_VALUES[index];
  }

  String male() {
    final int index = randomValue(MALE_VALUES.length);
    return MALE_VALUES[index];
  }

  String female() {
    final int index = randomValue(FEMALE_VALUES.length);
    return FEMALE_VALUES[index];
  }

  private int randomValue(final int max) {
    final int min = 0;
    return random.nextInt(max - min) + min;
  }
}
