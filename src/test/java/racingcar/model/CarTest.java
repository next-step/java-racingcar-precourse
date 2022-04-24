package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "asdasdasd"})
    @DisplayName("유효하지 않은 이름 등록")
    void name_fail(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }
}
