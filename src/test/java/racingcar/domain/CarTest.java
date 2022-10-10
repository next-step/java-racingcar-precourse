package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"test123", "nextstep", "carracing"})
    @DisplayName("자동차 이름이 5글자를 초과하는 경우 IllegalArgumentException이 발생한다.")
    void check_validate_carname_test(String carName) {
        assertThatThrownBy(() ->
            new Car(carName)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 이름은 5자 이하만 가능합니다.");
    }
}