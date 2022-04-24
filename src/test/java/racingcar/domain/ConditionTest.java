package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConditionTest {

    @ParameterizedTest
    @CsvSource({"0,false", "3,false", "4,true", "9,true"})
    void 숫자가_4_이상일_경우만_움직일_수_있음(int value, boolean isMovable) {
        Condition condition = new Condition(value);
        assertThat(condition.isMovableCondition()).isEqualTo(isMovable);
    }
}