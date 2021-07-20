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

import java.util.List;
import java.util.stream.Collectors;

public class ControlDigitCalculator {

  String controlDigit(final String first9Digits) {
    final List<Integer> arr = first9Digits.chars()
        .mapToObj(value -> Integer.parseInt(String.valueOf((char) value)))
        .collect(Collectors.toList());

    final int first = (arr.get(0) * (-1));
    final int second = (arr.get(1) * 5);
    final int third = (arr.get(2) * 7);
    final int forth = (arr.get(3) * 9);
    final int fifth = (arr.get(4) * 4);
    final int sixth = (arr.get(5) * 6);
    final int seventh = (arr.get(6) * 10);
    final int eighth = (arr.get(7) * 5);
    final int ninth = (arr.get(8) * 7);

    final int total = first + second + third + forth + fifth + sixth + seventh + eighth + ninth;

    final int controlDigit = (total % 11) % 10;
    return String.valueOf(controlDigit);
  }
}
