package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingGameIllegalArgumentException;

import static org.assertj.core.api.Assertions.*;

public class ExecutionCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10", "100"})
    void 숫자만_입력_가능(String input) {
        ExecutionCount executionCount = new ExecutionCount();
        assertThat(executionCount.isNumber(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "^", ""})
    void 숫자_이외_입력_불가능(String input) {
        assertThatThrownBy(() -> ExecutionCount.valueOf(input))
                .isInstanceOf(RacingGameIllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 0 이상의 숫자만 입력할 수 있습니다.");
    }

}
