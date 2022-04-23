package racingcar.racing;

import org.junit.jupiter.api.Test;
import racingcar.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LapTest {

    @Test
    void 시도회수_슛자가_아닐_경우_예외() {
        assertThatThrownBy(() -> new Lap("n8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LAP_COUNT_NOT_NUMBER);
    }

}
