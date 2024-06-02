package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttemptNumberValidatorTest {

    InputValidator attemptNumberValidator;

    @BeforeEach
    void setUp() {
        attemptNumberValidator = new AttemptNumberValidator();
    }

    @Test
    @DisplayName("숫자가 아닌 값 확인 테스트")
    void checkInputValueWithNoNumber() {
        String noNumber = "test";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            attemptNumberValidator.checkInputValue(noNumber);
        });
    }

    @Test
    @DisplayName("0 이상의 정수가 아닌 숫자 확인 테스트")
    void checkInputValueOutOfRange() {
        String negativeIntegerStr = "-1";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            attemptNumberValidator.checkInputValue(negativeIntegerStr);
        });
    }

    @Test
    @DisplayName("올바른 형식의 숫자 확인 테스트")
    void checkInputValueWithCorrectNumber() {
        String correctNumberStr = "5";
        Assertions.assertDoesNotThrow(() -> {
            attemptNumberValidator.checkInputValue(correctNumberStr);
        });
    }
}