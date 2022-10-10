package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.constant.InfoMessage;

class UserInputTest {
    @Test
    void constructorTest() {
        assertThatThrownBy(() -> new UserInput(null)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                InfoMessage.ERROR_MESSAGE_BEGIN);
    }
}