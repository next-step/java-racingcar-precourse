package com.racingcar.domain;

import com.racingcar.exception.RacingCarGameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingConditionTest {

    @DisplayName("움직이는 조건 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 8, 9})
    public void validateMovingConditionTest(Integer given) {

        // when
        MovingCondition result = MovingCondition.of(given);

        // then
        Assertions.assertThat(result).isNotNull();
    }


    @DisplayName("움직이는 조건 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    public void invalidMovingConditionTest(Integer given) {
        Assertions.assertThatThrownBy(() -> {
            MovingCondition result = MovingCondition.of(given);
            System.out.println(result);
        }).isInstanceOf(RacingCarGameException.class);
    }
}
