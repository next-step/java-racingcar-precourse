package com.racingcar.domain;

import com.racingcar.exception.RacingCarGameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @DisplayName("유효한 길이의 자동차 이름")
    @ParameterizedTest
    @ValueSource(strings = {"hong", "n", "valid"})
    public void checkValidCarNameLengthTest(String given) {

        // when
        CarName carName = CarName.of(given);

        // then
        Assertions.assertThat(carName).isNotNull();
    }

    @DisplayName("유효하지 않는 길이의 자동차 이름")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "invalid", "racingCar"})
    public void checkInvalidCarNameLength(String given) {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = CarName.of(given);
            System.out.println(carName);
        }).isInstanceOf(RacingCarGameException.class);
    }
}
