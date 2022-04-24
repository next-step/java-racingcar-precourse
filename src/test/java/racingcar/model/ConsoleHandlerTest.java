package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleHandlerTest {

    ConsoleHandler consoleHandler = new ConsoleHandler();

    @DisplayName("빈 입력 검증 확인")
    @Test
    void validateEmptyInputTest() {
        assertThatThrownBy(() -> consoleHandler.validateEmptyInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값은 공백일 수 없습니다.");
    }

    @DisplayName("숫자 아닌 입력값 확인")
    @Test
    void validateNumberInputTest() {
        assertThatThrownBy(() -> consoleHandler.validateNumberInput("a1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }
}