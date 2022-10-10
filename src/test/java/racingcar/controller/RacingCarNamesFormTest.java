package racingcar.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarNamesFormTest {

    @Test
    void 자동차이름_입력값_유효성_검증() {
        assertThatThrownBy(() -> new RacingCarNamesForm(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarNamesForm.ERROR_MSG_BLANK_OR_NULL);

        assertThatThrownBy(() -> new RacingCarNamesForm(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarNamesForm.ERROR_MSG_BLANK_OR_NULL);

        assertThatThrownBy(() -> new RacingCarNamesForm("pobi,woni, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarNamesForm.ERROR_MSG_BLANK_OR_NULL);

        assertThatThrownBy(() -> new RacingCarNamesForm("pobi,woni,stupid "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarNamesForm.ERROR_MSG_OVER_LENGTH_LIMIT);

        assertThatThrownBy(() -> new RacingCarNamesForm("pobi"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(RacingCarNamesForm.ERROR_MSG_NUMBER_OF_NAMES);
    }
}
