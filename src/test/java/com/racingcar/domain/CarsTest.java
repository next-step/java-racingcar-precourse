package com.racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

class CarsTest {

    @DisplayName("우승자 선출 테스트")
    @ParameterizedTest
    @MethodSource("provideElectWinnerParameter")
    public void electWinnersTest(Cars given, Winners expected) {

        // when
        Winners winners = given.electWinners();

        // then
        Assertions.assertThat(winners.length()).isEqualTo(expected.length());

        for (Winner winner : winners) {
            Assertions.assertThat(winner).isEqualTo(
                    expected.iterator().next()
            );
        }
    }

    private static Stream<Arguments> provideElectWinnerParameter() {
        return Stream.of(
                Arguments.of(
                        Cars.of(
                                Arrays.asList(
                                        Car.of(CarPosition.of(1), CarName.of("num1")),
                                        Car.of(CarPosition.of(2), CarName.of("num2")),
                                        Car.of(CarPosition.of(3), CarName.of("num3"))
                                )
                        ), Winners.of(
                                Collections.singletonList(
                                        Winner.of(CarName.of("num3"))
                                )
                        ),
                        Cars.of(
                                Arrays.asList(
                                        Car.of(CarPosition.of(1), CarName.of("num1")),
                                        Car.of(CarPosition.of(2), CarName.of("num2")),
                                        Car.of(CarPosition.of(3), CarName.of("num3"))
                                )
                        ), Winners.of(
                                Arrays.asList(
                                        Winner.of(CarName.of("num2")),
                                        Winner.of(CarName.of("num3"))
                                )
                        )
                )
        );
    }
}
