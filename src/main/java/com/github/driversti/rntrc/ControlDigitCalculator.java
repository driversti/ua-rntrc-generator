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
