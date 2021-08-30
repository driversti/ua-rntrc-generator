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

class PersonSerialNumberGenerator {

  private static final int SERIAL_NUMBER_LENGTH = 3;

  private final Random random;

  PersonSerialNumberGenerator(Random random) {
    this.random = random;
  }

  String random() {
    final int min = 0;
    final int max = 999;
    final String serialNumber = String.valueOf(random.nextInt(max - min) + min);
    return withLeadingZeros(serialNumber);
  }

  private String withLeadingZeros(String serialNumber) {
    if (serialNumber.length() >= SERIAL_NUMBER_LENGTH) {
      return serialNumber;
    }
    StringBuilder result = new StringBuilder(serialNumber);
    while (result.length() < SERIAL_NUMBER_LENGTH) {
      result.insert(0, "0");
    }
    return result.toString();
  }
}
