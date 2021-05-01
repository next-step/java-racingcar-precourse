package com.github.momentjin.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름이 5글자를 초과하면 IllegalArgumentException이 발생한다")
    @Test
    void getValue() {

        // given
        String carNameText = "이건여섯글자다";

        // when & then
        assertThatThrownBy(() -> new CarName(carNameText))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다");
    }

    @DisplayName("자동차 이름이 빈 값이면 IllegalArgumentException이 발생한다")
    @Test
    void getValue2() {

        // given
        String emptyCarNameText = "";

        // when & then
        assertThatThrownBy(() -> new CarName(emptyCarNameText))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값을 허용하지 않습니다");
    }
}