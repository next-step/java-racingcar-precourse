package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingRuleTest {
    @Test
    @DisplayName("random값이 4 이상일 경우 전진값을 리턴한다.")
    void over_4() {
        MovingRule movingRule = new MovingRule();
        MovingStatus result = movingRule.behave(4);
        assertThat(result.isGoing()).isEqualTo(true);
    }

    @Test
    @DisplayName("random값이 3 이하일 경우 멈춤값을 리턴한다.")
    void under_3() {
        MovingRule movingRule = new MovingRule();
        MovingStatus result = movingRule.behave(3);
        assertThat(result.isStopping()).isEqualTo(true);
    }
}
