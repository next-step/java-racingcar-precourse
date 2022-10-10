package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.domain.CarName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("자동차 이름")
class CarNameTest {

    @DisplayName("자동차 이름 생성")
    @Test
    void createCarName() {
        assertDoesNotThrow(() -> new CarName("람보르기니"));
    }

    @DisplayName("자동차 이름은 null 또는 공백일 수 없다.")
    @NullAndEmptySource
    @ParameterizedTest
    void createEmptyName(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 null 이나 공백일 수 없습니다.");
    }

    @DisplayName("자동차 이름은 5자보다 클 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = "람보르기니 우라칸, 포르쉐911")
    void createCarNameSixLength(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자를 넘을 수 없습니다.");
    }
}
