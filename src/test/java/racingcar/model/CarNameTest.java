package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {
    @DisplayName("이름이 5자 초과 시 에러")
    @Test
    void validate() {
        assertThrows(IllegalArgumentException.class, () -> new CarName("123456"));
    }
}
