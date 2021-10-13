package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.msg.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceNumTest {
    @Test
    @DisplayName("경주 횟수는 0이상 2^31미만이어야 한다.")
    void 경주_횟수_참() {
        assertThatNoException().isThrownBy(() -> new RaceNum(String.valueOf(0)));
        assertThatNoException().isThrownBy(() -> new RaceNum(String.valueOf((int)(Math.pow(2, 31)-1))));
    }

    @Test
    @DisplayName("경주 횟수는 0미만 2^31이상이 되지 않아야 한다.")
    void 경주_횟수_거짓() {
        assertThatThrownBy(() -> new RaceNum(null))
                .hasMessage(ErrorMessage.RACE_NUM_CAN_NOT_BE_NULL);
        assertThatThrownBy(() -> new RaceNum(""))
                .hasMessage(ErrorMessage.RACE_NUM_LENGTH_CAN_BE_IN_VALID_RANGE);
        assertThatThrownBy(() -> new RaceNum(String.valueOf(Math.pow(2, 31))))
                .hasMessage(ErrorMessage.RACE_NUM_CAN_BE_INTEGER);
        assertThatThrownBy(() -> new RaceNum(String.valueOf(-1)))
                .hasMessage(ErrorMessage.RACE_NUM_CAN_BE_POSITIVE);
    }
}
