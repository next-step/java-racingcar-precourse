package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import racingcar.common.ErrorMessage;

class NameTest {

    @Test
    void 자동차이름_입력하지_않을경우_예외() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> new Name(""));
        assertThat(throwable.getMessage()).isEqualTo(ErrorMessage.ERROR_EMPTY_CARS_NAME);
    }

    @Test
    void 자동차이름_5글자_넘을경우_예외() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> new Name("javaji"));
        assertThat(throwable.getMessage()).isEqualTo(ErrorMessage.ERROR_MAX_CAR_NAME_LENGTH);
    }
}