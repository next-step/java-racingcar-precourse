package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInputTest {

    @Test
    void 공백_입력() {
        String input = "";
        UserInput userInput = new UserInput();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> userInput.setCarNames(input));
    }

}