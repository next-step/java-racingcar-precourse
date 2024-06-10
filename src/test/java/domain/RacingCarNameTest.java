package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "cobi"})
    @DisplayName("racing car 생성 test")
    void test_name_constructor_success(String input) {
        // when
        RacingCarName racingCarName = new RacingCarName(input);

        // then
        assertThat(racingCarName.carName()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"","avante", "sonata"})
    @DisplayName("경주할 자동차 이름은 유효한 범위(1이상 5이하)를 가져야한다. ")
    void test_name_constructor_fail_over_length_name(String carName) {
        // given
        String expectedMessage = "자동차이름은 1자리이상 5자 이하만 가능합니다.";

        // when & then
        assertThatThrownBy(() -> new RacingCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
