package racingcar.common.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.validate.ValidateUtils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    private static final String DEFAULT_SOURCE = "abcdefeghijklmnop";

    @Test
    @DisplayName("규칙에 맞을 때 정상 생성되어야 한다.")
    void carNameNormal() {
        // given
        String name =  DEFAULT_SOURCE.substring(0, CarName.CAR_NAME_MAX_LENGTH);

        assertThatCode(() -> new CarName(name))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("name 이 null 일 때 예외가 발생해야 한다.")
    void carNameNull() {
        assertThatThrownBy(() -> new CarName(null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateUtils.SOURCE_NULL_MSG);
    }

    @Test
    @DisplayName("name 이 길면 예외가 발생해야 한다.")
    void carNameLong() {
        // given
        final String name = DEFAULT_SOURCE.substring(0, CarName.CAR_NAME_MAX_LENGTH + 1);

        assertThatThrownBy(() -> new CarName(name))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateUtils.TOO_LONG_MSG_HOLDER, name);
    }
}