package racingcar;

import main.java.racingcar.domain.TrialCount;
import main.java.racingcar.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TrialCountTest {

    @DisplayName("TrialCount 0으로 생성시 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 9999999})
    void trialCountSuccess(int count) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new TrialCount(count));
    }

    @DisplayName("TrialCount 음수로 생성시 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -9999})
    void trialCountException(int count) {
        Assertions.assertThatThrownBy(() -> new TrialCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NEGATIVE);
    }

    @DisplayName("isMoreThan.")
    @Test
    void moreThan() {
        TrialCount trialCount = new TrialCount(10);
        Assertions.assertThat(trialCount.isMoreThan(9)).isTrue();
        Assertions.assertThat(trialCount.isMoreThan(10)).isFalse();
        Assertions.assertThat(trialCount.isMoreThan(11)).isFalse();
    }
}
