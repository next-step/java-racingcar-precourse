package dev.heowc.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("조건에 대해 테스트한다.")
class ConditionTest {

    @DisplayName(Condition.MIN + " ~ " + Condition.MAX + "사이 이외의 값으로는 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, Condition.MIN - 1, Condition.MAX + 1, Integer.MAX_VALUE})
    void failureCreate(int value) {
        assertThatThrownBy(() -> {
            Condition.of(value);
        }).isInstanceOf(InvalidConditionException.class)
        .hasMessage("전진 조건에 대한 값이 올바르지 않습니다.");
    }

    @DisplayName(Condition.MIN + " ~ " + Condition.MAX + "사이 값으로 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {Condition.MIN, 1, 2, 3, 4, 5, 6, 7, 8, Condition.MAX})
    void successfulCreate(int value) {
        assertThat(Condition.of(value)).isNotNull();
    }

    @DisplayName("같은 값은 동등성을 보장한다.")
    @Test
    void equals() {
        final Condition condition = Condition.of(5);
        final Condition otherCondition = Condition.of(5);
        assertThat(condition).isEqualTo(otherCondition);
    }
}