package com.github.driversti.rntrc;

public class Runner {

  public static void main(String[] args) {
    final RntrcGenerator generator = new RntrcGenerator();
    final String rntrc = generator.rntrc();
    System.out.println(rntrc);
  }

}
