package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.ErrorMessage.*;

public class IllegalArgumentCheckTest {

    private final String LONG_NAME = "morethan5";
    private final String STRING_TEXT = "다섯번";

    @Test
    void 자동자_이름은_다섯자_이하() {
        // 여섯자 이상인 경우에는 IllegalArgumentException가 발생한다.
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new Car().initCarName(LONG_NAME);
                });
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_NOT_MORE_THAN_5);
    }

    @Test
    void 경주_차수는_숫자만_가능() {
        // 숫자로 구성된게 아니라면 IllegalArgumentException가 발생한다.
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new RoundNumber().initRoundNumber(STRING_TEXT);
                });
        assertThat(exception.getMessage()).isEqualTo(RACING_ROUND_MUST_NUMBER);
    }

}
