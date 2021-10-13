package racinggame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LapCountValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 실행_횟수가_1미만일_경우_예외를_던진다(int runCount) {
        assertThatThrownBy(() -> LapCountValidator.validate(runCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 실행 횟수는 1회 이상이어야 합니다");
    }

    @Test
    void 실행_횟수가_1이상일_경우_유효성_검증을_통과한다() {
        assertThatCode(() -> LapCountValidator.validate(1)).doesNotThrowAnyException();
    }
}
