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

class RntrcGeneratorFactoryTest extends UnitTest {

    @Subject
    private RntrcGeneratorFactory factory

    void setup() {
        factory = new RntrcGeneratorFactory()
    }

    def "should be possible to build a generator and generate a random RNTRC"() {
        when:
        def generator = factory.create()

        then:
        generator != null

        and:
        def rntrc = generator.random()
        rntrc != null
        println rntrc
    }
}
