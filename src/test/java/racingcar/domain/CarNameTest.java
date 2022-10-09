package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("빈값_입력_체크")
    void 빈값_입력_체크() {
        assertThatThrownBy(
                () -> new CarName("")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_CAR_NAME_EMPTY);
    }

    @Test
    @DisplayName("길이_5자_이하_이름_채크")
    void 길이_5자_이하_이름_채크() {
        assertThatThrownBy(
                () -> new CarName("pobipobi")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_CAR_NAME_OVER_SIZE);
    }

}
