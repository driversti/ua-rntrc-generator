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

class RntrcGeneratorTest extends UnitTest {

    private DaysToBirthdayGenerator daysToBdayGenerator
    private PersonSerialNumberGenerator personSNGenerator
    private SexGenerator sexGenerator
    private ControlDigitCalculator controlDigitCalculator

    @Subject
    private RntrcGenerator rntrcGenerator

    void setup() {
        daysToBdayGenerator = Mock()
        personSNGenerator = Mock()
        sexGenerator = Mock()
        controlDigitCalculator = Mock()
        rntrcGenerator = new RntrcGenerator(
                daysToBdayGenerator, personSNGenerator, sexGenerator, controlDigitCalculator
        )
    }

    @Unroll
    def "should generate random rntrc"() {
        given:
        daysToBdayGenerator.random() >> daysToBD
        personSNGenerator.random() >> serialNumber
        sexGenerator.random() >> sex
        controlDigitCalculator.controlDigit(daysToBD + serialNumber + sex) >> controlDigit

        expect:
        rntrcGenerator.random() == daysToBD + serialNumber + sex + controlDigit

        where:
        daysToBD | serialNumber | sex | controlDigit || _
        "13035"  | "305"        | "0" | "5"          || _
        "03386"  | "040"        | "9" | "4"          || _
        "39358"  | "503"        | "3" | "8"          || _
    }
}
