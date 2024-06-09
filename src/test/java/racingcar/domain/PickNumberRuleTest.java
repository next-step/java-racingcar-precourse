package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 뽑기 룰 테스트")
public class PickNumberRuleTest {
    @RepeatedTest(100)
    @Test
    void 숫자_0부터_9까지의_숫자를_뽑는다() {
        PickNumberRule pickNumberRule = PickNumberRules.RANDOM;

        int value = pickNumberRule.pick();

        assertAll(
                () -> assertThat(value >= 0).isTrue(),
                () -> assertThat(value <= 9).isTrue()
        );
    }
}
