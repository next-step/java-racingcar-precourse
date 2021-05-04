package com.racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class CarTest {


    @DisplayName("자동차는 4에서 9이하의 값이면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveCarTest(Integer flag) {
        // when
        Car car = Car.of(CarPosition.of(flag), CarName.of("temp"));
        Boolean isMoving = car.isCarMoving(MovingCondition.of(flag));

        // then
        Assertions.assertThat(isMoving).isEqualTo(Boolean.TRUE);
    }

    @DisplayName("자동차는 0에서 3이하의 값이면 멈춘다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void stayCarTest(Integer flag) {
        // when
        Car car = Car.of(CarPosition.of(flag), CarName.of("temp"));
        Boolean isMoving = car.isCarMoving(MovingCondition.of(flag));

        // then
        Assertions.assertThat(isMoving).isEqualTo(Boolean.FALSE);
    }

    @DisplayName("자동차가 같은 위치에 있는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideSamePositionParameter")
    public void isSamePositionTest(Car car, Boolean expected) {

        // given
        Car maxPositionCar = Car.of(CarPosition.of(4), CarName.of("top"));

        // when
        Boolean result = maxPositionCar.isSamePosition(car);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSamePositionParameter() {
        return Stream.of(
                Arguments.of(Car.of(CarPosition.of(1), CarName.of("temp")), Boolean.FALSE),
                Arguments.of(Car.of(CarPosition.of(4), CarName.of("temp")), Boolean.TRUE)
        );
    }
}
