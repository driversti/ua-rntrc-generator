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

import java.time.LocalDate
import spock.lang.Subject
import spock.lang.Unroll

class DaysToBirthdayGeneratorTest extends UnitTest {

    private LocalDateGenerator localDateGenerator

    @Subject
    private DaysToBirthdayGenerator subject

    void setup() {
        localDateGenerator = Mock()
        subject = new DaysToBirthdayGenerator(localDateGenerator)
    }

    @Unroll
    def "should add leading zeros when necessary"() {
        given:
        final LocalDate birthday = LocalDate.parse(givenDate)

        when:
        final String days = subject.bornOn(birthday)

        then:
        days == expected

        where:
        givenDate    || expected
        "1900-01-01" || "00001"
        "1900-12-12" || "00346"
        "1986-09-08" || "31662"
    }
}
