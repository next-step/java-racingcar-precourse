package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LapCountTest {

    @Test
    @DisplayName("lap 횟수는 사용자 입력 값으로 설정된다.")
    void createLapCount() {
        LapCount lapCount = LapCount.createLapCount("3");
        assertThat(lapCount.getLapCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("lap 횟수는 숫자만 입력 가능하다.")
    void onlyNumberLapCount() {
        assertThatThrownBy(() -> LapCount.createLapCount("str"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("lap 횟수는 양의 정수만 입력 가능하다.")
    void onlyPositiveNumberLapCount() {
        assertThatThrownBy(() -> LapCount.createLapCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> LapCount.createLapCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        LapCount lapCount = LapCount.createLapCount("1");
        assertThat(lapCount.getLapCount()).isEqualTo(1);
    }
}