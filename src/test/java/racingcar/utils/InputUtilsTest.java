package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputUtilsTest {

    @Test
    @DisplayName("인자로 전달받은 문자열 반환")
    void inputStringTest() {
        String input = "test";
        assertEquals(input, InputUtils.inputString(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @DisplayName("인자로 전달받은 문자열을 정수로 변환하여 반환")
    void inputIntTest(String input) {
        int ints = Integer.parseInt(input);
        assertEquals(ints, InputUtils.inputInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "4c4", "d1", "e"})
    @DisplayName("숫자가 아닌 문자열을 전달받으면 예외 발생")
    void inputIntExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputUtils.inputInt(input));
    }


}