package racingcar.rule;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GoStopRuleTest {

    @Test
    void 랜덤값_범위에_따라_전진_또는_멈춤() {
        int size = 4;
        GoStopRule goStopRule = new GoStopRule(size);
        assertThat(goStopRule.get(size - 1)).isNotNull();
        goStopRule.determineGoStop(0, 0);
        assertThat(goStopRule.get(0)).isEqualTo(GoStop.STOP);
        goStopRule.determineGoStop(1, 3);
        assertThat(goStopRule.get(1)).isEqualTo(GoStop.STOP);
        goStopRule.determineGoStop(2, 4);
        assertThat(goStopRule.get(2)).isEqualTo(GoStop.GO);
        goStopRule.determineGoStop(3, 9);
        assertThat(goStopRule.get(3)).isEqualTo(GoStop.GO);
    }

    @Test
    void 랜덤값이_오류일경우_예외던진다() {
        GoStopRule goStopRule = new GoStopRule(1);
        assertThatThrownBy(() -> goStopRule.determineGoStop(2, -1))
            .isInstanceOf(IllegalStateException.class);
    }
}