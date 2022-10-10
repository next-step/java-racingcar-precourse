package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveTest {
    @Test
    @DisplayName("입력값이 4 미만이면 움직이지 않는다.")
    void move_less_than_4() {
        Move move = new Move();
        move.execute(3);
        Assertions.assertThat(move.isMoved()).isFalse();

    }

    @Test
    @DisplayName("입력값이 4 이상이면 움직인다.")
    void move_4_or_more() {
        Move move = new Move();
        move.execute(4);
        Assertions.assertThat(move.isMoved()).isTrue();
    }

    @Test
    @DisplayName("입력값이 0 미만이면 에러가 발생한다.")
    void move_less_than_0() {
        Move move = new Move();
        Assertions.assertThatThrownBy(() -> move.execute(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0이상 9이하의 값을 입력해 주세요");
    }

    @Test
    @DisplayName("입력값이 9 초과면 에러가 발생한다.")
    void move_greater_than_9() {
        Move move = new Move();
        Assertions.assertThatThrownBy(() -> move.execute(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0이상 9이하의 값을 입력해 주세요");
    }
}
