package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {
    @Test
    @DisplayName("1 ~ 5자리의 자동차 이름을 생성한다.")
    void createLapCount() {
        // given
        String value = "car1";

        // when
        CarName carName = assertDoesNotThrow(() -> new CarName(value));

        // then
        assertThat(carName.getName()).isEqualTo(value);
    }

    @ParameterizedTest(name = "{displayName} message={0}")
    @ValueSource(strings = {"", " ", "car123"})
    @DisplayName("자동차 이름이 빈값, 공백, 6자 이상이면 예외가 발생한다.")
    void createCarNameThrows(String value) {
        // given

        // when
        Executable executable = () -> new CarName(value);

        // then
        assertThrows(IllegalArgumentException.class, executable);
    }
}
