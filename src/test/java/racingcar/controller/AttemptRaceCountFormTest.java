package racingcar.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptRaceCountFormTest {
    @Test
    void 입력값_유효성_검증_테스트() {
        assertThatThrownBy(() -> new AttemptRaceCountForm(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AttemptRaceCountForm.ERROR_MSG_BLANK_OR_NULL);

        assertThatThrownBy(() -> new AttemptRaceCountForm(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AttemptRaceCountForm.ERROR_MSG_BLANK_OR_NULL);

        assertThatThrownBy(() -> new AttemptRaceCountForm("test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AttemptRaceCountForm.ERROR_MSG_NOT_NUMBER_FORMAT);

        assertThatThrownBy(() -> new AttemptRaceCountForm("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AttemptRaceCountForm.ERROR_MSG_OUT_OF_RANGE);
    }
}
