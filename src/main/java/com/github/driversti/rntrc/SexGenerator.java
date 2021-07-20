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

public class SexGenerator {

  private final Random random;

  public SexGenerator() {
    this.random = new Random();
  }

  public SexGenerator(Random random) {
    this.random = random;
  }

  String sex() {
    final int minInclusive = 0;
    final int maxExclusive = 9;
    return String.valueOf(random.nextInt(maxExclusive - minInclusive) + minInclusive);
  }
}
