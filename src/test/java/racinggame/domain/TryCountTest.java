package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static racinggame.domain.GameErrorMessage.ERROR_TRY_COUNT_GREATER_THAN_ZERO;

class TryCountTest {
    @ParameterizedTest(name = "경주의 시도할 횟수[{0}]는 0보다 큰 숫자를 입력해야 한다")
    @ValueSource(strings = {"0", "-10"})
    void 경주의_시도할_횟수는_0_보다_큰_숫자를_입력해야_한다(String readLine) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new TryCount(readLine);
                })
                .withMessage(ERROR_TRY_COUNT_GREATER_THAN_ZERO.getErrorMessage());
    }

    @ParameterizedTest(name = "[{0}] 경주의 시도할 횟수 입력값은 숫자만 유효하다")
    @ValueSource(strings = {"a", "B", "%", "한글", "10.5"})
    void 입력값은_숫자만_유효하다(String readLine) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    new TryCount(readLine);
                });
    }

    @ParameterizedTest(name = "[{0}] 경주의 시도할 횟수 입력값은 0보다 큰 숫자만 유효하다")
    @ValueSource(strings = {"1", "5", "10", "100"})
    void 입력값은_0_보다_큰_숫자만_유효하다(String readLine) {
        assertThatCode(() -> new TryCount(readLine)).doesNotThrowAnyException();
    }
}