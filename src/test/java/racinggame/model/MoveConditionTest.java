package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.enums.Error;
import racinggame.model.enums.MoveAction;

import static org.assertj.core.api.Assertions.*;

@DisplayName("MoveValue: 자동차의 전진/멈춤 여부를 판단하는 값")
public class MoveConditionTest {

    @DisplayName("0 미만, 9 초과의 값이 들어오면 범위 에러")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void testRange(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new MoveCondition(value))
                .withMessage(Error.INVALID_MOVE_CONDITION_RANGE.message());
    }

    @DisplayName("0 ~ 3 의 값이면 멈춤 조건")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void testStop(int value) {
        MoveCondition condition = new MoveCondition(value);
        assertThat(condition.judge()).isEqualTo(MoveAction.STOP);
    }

    @DisplayName("4 ~ 9 의 값이면 전진 조건")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testGo(int value) {
        MoveCondition condition = new MoveCondition(value);
        assertThat(condition.judge()).isEqualTo(MoveAction.GO);
    }
}
