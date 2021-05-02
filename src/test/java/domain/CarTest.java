package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자리수 이하인지 테스트")
    @ValueSource(strings = {"hiImCar"})
    void 자동차_이름_자리수_검증(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 space 값이 들어오는 경우 예외처리 확인")
    @ValueSource(strings = {" ", "  hi"})
    void 자동차_이름_스페이스값_검증(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
