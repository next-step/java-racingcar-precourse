package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberComparingMoveConditionTest {

    @ParameterizedTest(name = "입력 값이 4이상인 경우 전진 조건을 충족한다. [{arguments}]")
    @CsvSource(value = {"3,false", "4,true"})
    void moveConditionSatisfyTest(final int number, final boolean expected) {
        final MoveCondition moveCondition = new NumberComparingMoveCondition(number);
        final boolean actual = moveCondition.isSatisfied();
        assertThat(actual).isEqualTo(expected);
    }
}