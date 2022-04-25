package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("입력한 자동차 이름이 5자 초과할 경우 예외 발생")
    void validateLength() {
        String[] carNames = new String[]{"invalidName", "pobi", "woni"};
        assertThatThrownBy(() -> new CarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }
}