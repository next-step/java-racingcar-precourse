package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("조건에 대해 테스트한다.")
class ConditionTest {

    @ParameterizedTest(name = "Condition을 생성하는 대해 성공한다. value={0}")
    @ValueSource(ints = {Condition.MIN, 1, 2, 3, 4, 5, 6, 7, 8, Condition.MAX})
    void successfulCreatingCondition(int value) {
        assertThat(Condition.of(value)).isNotNull();
    }

    @ParameterizedTest(name = "Condition을 생성하는 대해 실패한다. value={0}")
    @ValueSource(ints = {Integer.MIN_VALUE, Condition.MIN - 1, Condition.MAX + 1, Integer.MAX_VALUE})
    void failureCreatingCondition(int value) {
        assertThatThrownBy(() -> {
            Condition.of(value);
        }).isInstanceOf(InvalidConditionException.class);
    }

    @ParameterizedTest(name = "Condition은 비교가 가능하다. value={0}, otherValue={1}, expected={2}")
    @CsvSource({
            "1,1,0",
            "1,2,-1",
            "2,1,1"
    })
    void compareTo(int value, int otherValue, int expected) {
        final Condition condition = Condition.of(value);
        final Condition otherCondition = Condition.of(otherValue);
        assertThat(condition.compareTo(otherCondition)).isEqualTo(expected);
    }
}
