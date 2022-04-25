package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LapCountTest {

    @Test
    @DisplayName("주행바퀴수는 숫자를 입력받아 저장한다")
    void 주행바퀴수는_숫자를_입력받아_저장한다() {
        LapCount lapCount = new LapCount(5);
        assertThat(lapCount.getLapCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("1미만의 숫자를 입력받으면 오류를 출력한다")
    void 일미만의_숫자를_입력받으면_오류를_출력한다() {
        assertThatThrownBy(() -> {
            LapCount lapCount = new LapCount(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
