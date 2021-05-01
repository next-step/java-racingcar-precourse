package com.racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @DisplayName("자동차는 4에서 9이하의 값이면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveCarTest(Integer flag) {
        // when
        Car car = new Car(null);
        Boolean isMoving = car.isCarMoving(MovingCondition.of(flag));

        // then
        Assertions.assertThat(isMoving).isEqualTo(Boolean.TRUE);
    }

    @DisplayName("자동차는 0에서 3이하의 값이면 멈춘다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void stayCarTest(Integer flag) {
        // when
        Car car = new Car(null);
        Boolean isMoving = car.isCarMoving(MovingCondition.of(flag));

        // then
        Assertions.assertThat(isMoving).isEqualTo(Boolean.FALSE);
    }
}
