package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.exception.CustomIllegalArgumentException;
import racingcar.exception.CustomNumberFormatException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class RepeatTest {

    @Test
    void 입력값테스트() {
        assertThatThrownBy(() ->
                new Repeat("12E")
        ).isInstanceOf(CustomNumberFormatException.class).hasMessage("[ERROR] 시도할 횟수는 숫자여야 합니다.");
    }

    @Test
    void 양수테스트() {
        assertThatThrownBy(() ->
                new Repeat("-1")
        ).isInstanceOf(CustomIllegalArgumentException.class).hasMessage("[ERROR] 시도할 횟수는 0보다 커야 합니다.");
    }
}
