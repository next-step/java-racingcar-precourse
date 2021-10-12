package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.msg.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {
    @Test
    @DisplayName("자동차의 이름은 1자 이상, 5자 이하여야 한다.")
    void 자동차_이름_부여_참() {
        assertThatNoException().isThrownBy(() -> new CarName("자"));
        assertThatNoException().isThrownBy(() -> new CarName("자동차이름"));
    }

    @Test
    @DisplayName("자동차의 이름은 1자 미만, 5자 초과가 되지 않아야 한다.")
    void 자동차_이름_부여_거짓() {
        assertThatThrownBy(() -> new CarName(null))
                .hasMessage(ErrorMessage.CAR_NAME_CAN_NOT_BE_NULL);
        assertThatThrownBy(() -> new CarName(""))
                .hasMessage(ErrorMessage.CAR_NAME_LENGTH_CAN_BE_IN_VALID_RANGE);
        assertThatThrownBy(() -> new CarName(" "))
                .hasMessage(ErrorMessage.CAR_NAME_CAN_NOT_BE_IN_BLANK);
        assertThatThrownBy(() -> new CarName("자동차이름2"))
                .hasMessage(ErrorMessage.CAR_NAME_LENGTH_CAN_BE_IN_VALID_RANGE);
    }
}
