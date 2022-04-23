package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveCountTest {

    @DisplayName("이동할 횟수가 5인 상태에서 이동횟수를 2번 감소시키면 남은 이동횟수는 3이어야 한다")
    @Test
    void remaining_count_test() {
        MoveCount moveCount = new MoveCount(5);

        moveCount.decrease();
        moveCount.decrease();

        assertThat(moveCount.getRemainingMoveCount()).isEqualTo(3);
    }

    @DisplayName("이동할 횟수가 8인 상태에서 이동횟수를 7번 감소시키면 남은 이동횟수는 1이어야 한다")
    @Test
    void remaining_count_test_v2() {
        MoveCount moveCount = new MoveCount(8);

        moveCount.decrease();
        moveCount.decrease();
        moveCount.decrease();
        moveCount.decrease();
        moveCount.decrease();
        moveCount.decrease();
        moveCount.decrease();

        assertThat(moveCount.getRemainingMoveCount()).isEqualTo(1);
    }

    @DisplayName("이동할 횟수보다 더 많은 이동횟수를 감소시키면 IllegalStatsException 을 발생시켜야 한다")
    @Test
    void remaining_count_exception_test() {
        MoveCount moveCount = new MoveCount(2);

        moveCount.decrease();
        moveCount.decrease();

        assertThatThrownBy(moveCount::decrease)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ExceptionType.NOT_DECREASE_MOVE_COUNT.getMessage());
    }

    @DisplayName("이동할 횟수가 0보다 크면 이동 가능해야 한다")
    @Test
    void movable_test() {
        MoveCount moveCount = new MoveCount(2);

        assertTrue(moveCount.isMovableCount());
    }

    @DisplayName("이동할 횟수가 0보다 같거나 작으면 이동이 불가능해야 한다")
    @Test
    void movable_test_v2() {
        MoveCount 이동가능횟수_0 = new MoveCount(0);
        MoveCount 이동가능횟수_음수 = new MoveCount(-3);

        assertFalse(이동가능횟수_0.isMovableCount());
        assertFalse(이동가능횟수_음수.isMovableCount());
    }
}
