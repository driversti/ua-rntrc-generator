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

package com.github.driversti.rntrc

import spock.lang.Subject
import spock.lang.Unroll

class SexGeneratorTest extends UnitTest {

    private Random random

    @Subject
    private SexGenerator generator

    void setup() {
        random = Mock()
        generator = new SexGenerator(random)
    }

    @Unroll
    def "should return #expectedValue when we generate random sex for the value #randomValue"() {
        given:
        random.nextInt(10) >> randomValue

        when:
        def actual = generator.random()

        then:
        actual == expectedValue

        where:
        randomValue || expectedValue
        0           || "0"
        1           || "1"
        2           || "2"
        3           || "3"
        4           || "4"
        5           || "5"
        6           || "6"
        7           || "7"
        8           || "8"
        9           || "9"
    }

    @Unroll
    def "should return #expectedValue for male when the random value is #randomValue"() {
        given:
        random.nextInt(5) >> randomValue

        when:
        def actual = generator.male()

        then:
        actual == expectedValue

        where:
        randomValue || expectedValue
        0           || "1"
        1           || "3"
        2           || "5"
        3           || "7"
        4           || "9"
    }

    @Unroll
    def "should return #expectedValue for female when the random value is #randomValue"() {
        given:
        random.nextInt(5) >> randomValue

        when:
        def actual = generator.female()

        then:
        actual == expectedValue

        where:
        randomValue || expectedValue
        0           || "0"
        1           || "2"
        2           || "4"
        3           || "6"
        4           || "8"
    }
}
