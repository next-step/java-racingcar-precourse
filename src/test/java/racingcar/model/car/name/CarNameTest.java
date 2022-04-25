package racingcar.model.car.name;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.name.CarName;

class CarNameTest {

    @Test
    @DisplayName("이름의 길이가 5인 경우 통과")
    void 길이가_5인_이름_검증통과() {
        assertDoesNotThrow(() -> new CarName("abcde"));
    }

    @Test
    @DisplayName("이름의 길이가 1인 경우 통과")
    void 길이가_1인_이름_검증통과() {
        assertDoesNotThrow(() -> new CarName("a"));
    }

    @Test
    @DisplayName("이름이 null인 경우 예외 발생")
    void 이름_null_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(null));
    }

    @Test
    @DisplayName("이름의 길이가 0인 경우 예외 발생")
    void 길이가_0인_이름_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
    }

    @Test
    @DisplayName("이름의 길이가 5보다 큰 경우 예외 발생")
    void 길이가_6인_이름_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new CarName("abcdef"));
    }
}