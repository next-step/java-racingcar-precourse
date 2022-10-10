package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.message.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameErrorsTest {
    private GameErrors gameErrors;

    @BeforeEach
    void setUp() {
        gameErrors = new GameErrors();
    }

    @Test
    @DisplayName("에러가 존재하는 경우")
    void initializing_cars_test() {
        // Given
        String defaultMessage = "[ERROR] 레이싱카 이름에 특수문자가 포함되서는 안됩니다(공백문자 포함).";

        // when
        gameErrors.setDefaultMessage(defaultMessage);

        // Then
        assertAll(
                () -> assertThat(gameErrors.hasError()).isTrue(),
                () -> assertThat(gameErrors.getDefaultMessage()).isEqualTo(ExceptionMessage.CONTAIN_SPECIAL_CHARACTER_EXCEPTION_MESSAGE)
        );
    }
}