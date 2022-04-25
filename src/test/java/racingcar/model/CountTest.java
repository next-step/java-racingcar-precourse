package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

public class CountTest {

    @Test
    void 시도_횟수_생성_검증() {
        Count count = new Count("5");
        assertThat(count.getAttemptCount()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"tes", "00f", "#$*"})
    void 숫자만_입력_가능한지_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Count(input);
        }).withMessageContaining(ErrorMessage.NUMBER_ATTEMPT_COUNT_ERROR.getMessage());
    }

    @Test
    void 제로_입력_가능한지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Count("0");
        }).withMessageContaining(ErrorMessage.MORE_THAN_ZERO_ATTEMPT_COUNT_ERROR.getMessage());
    }

}
