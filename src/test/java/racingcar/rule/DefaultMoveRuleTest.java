package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DefaultMoveRule에 대해서 테스트한다.")
class DefaultMoveRuleTest {

    private final MoveRule moveRule = new DefaultMoveRule();

    @ParameterizedTest(name = "MoveRuleResult를 반환한다. value={0}, expected={1}")
    @CsvSource({
            "1, STOP",
            "2, STOP",
            "3, STOP",
            "4, GO",
            "5, GO",
            "6, GO",
            "7, GO",
            "8, GO",
            "9, GO"
    })
    void test(int value, MoveRuleResult expected) {
        final MoveRuleResult moveRuleResult = moveRule.tryMove(Condition.of(value));
        assertThat(moveRuleResult).isEqualTo(expected);
    }
}
