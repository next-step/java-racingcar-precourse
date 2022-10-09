package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Name;

class RacingGameIllegalArgumentExceptionTest {

    @DisplayName("예외메시지는 [ERROR]로 시작해야 한다.")
    @Test
    void 예외_메시지_형식_검증() {
        Assertions.assertThatThrownBy(() -> Name.valueOf("abcde6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

}