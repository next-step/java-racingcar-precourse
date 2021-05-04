package com.racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CarPositionTest {


    @DisplayName("자동차 위치에 따라서 자동차 모양 만드는 테스트")
    @ParameterizedTest
    @MethodSource("provideCarPositionParameter")
    public void makeCarPositionTest(CarPosition given, String shape, String expected) {

        // when
        String result = given.makeCarPosition(shape);

        // then
        Assertions.assertThat(result).isEqualTo(expected);

    }

    private static Stream<Arguments> provideCarPositionParameter() {
        return Stream.of(
                Arguments.of(CarPosition.of(1), "-", "-"),
                Arguments.of(CarPosition.of(2), "-", "--"),
                Arguments.of(CarPosition.of(3), "-", "---")
        );
    }
}
