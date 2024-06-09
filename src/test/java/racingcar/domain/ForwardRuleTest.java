package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("전진 룰 테스트")
public class ForwardRuleTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 10, 100, 999})
    void 숫자가_4_이상이면_전진한다(final int number) {
        ForwardRule forwardRule = ForwardRules.MORE_THAN_FOUR;

        assertThat(forwardRule.isForward(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1, 0, -4, -10, -999})
    void 숫자가_4_이상이면_전진하지_않는다(final int number) {
        ForwardRule forwardRule = ForwardRules.MORE_THAN_FOUR;

        assertThat(forwardRule.isForward(number)).isFalse();
    }
}
