package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;
import static racingcar.type.ErrorMessageType.TRY_COUNT_NOT_ALLOW_LESS_THAN_ONE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"@", "q", "M"})
    @DisplayName("사용자가 입력한 값이 숫자가 아니라면 IllegalArgumentException 예외가 발생한다.")
    void input_onlyAllowNumber(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new TryCount(input);
                })
                .withMessageContaining(INPUT_ONLY_ALLOW_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("사용자가 입력한 값이 1보다 작다면 IllegalArgumentException 예외가 발생한다.")
    void input_tryCountNotAllowLessThanOne(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new TryCount(input);
                })
                .withMessageContaining(TRY_COUNT_NOT_ALLOW_LESS_THAN_ONE.getMessage());
    }

    @Test
    @DisplayName("입력한 숫자가 정상이면 TryCount가 생성된다.")
    void input_success() {
        TryCount tryCount = new TryCount("4");
        assertThat(tryCount.getCount()).isEqualTo(4);
    }
}