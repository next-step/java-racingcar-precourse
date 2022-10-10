package racingcar.domain.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TryCount;

class InputTryCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"1 ", " 3"})
    @DisplayName("사용자가 입력한 값에 공백이 존재한다면 IllegalArgumentException 예외가 발생한다.")
    void input_notAllowNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new InputTryCount(input);
                })
                .withMessageContaining(INPUT_NOT_ALLOW_BLANK.getMessage());
    }

    @Test
    @DisplayName("입력한 숫자가 정상이면 TryCount가 생성된다.")
    void input_success() {
        Input<TryCount> inputTryCount = new InputTryCount("3");
        TryCount tryCount = inputTryCount.create();
        assertThat(tryCount.getCount()).isEqualTo(3);
    }
}