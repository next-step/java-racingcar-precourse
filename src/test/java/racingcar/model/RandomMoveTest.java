package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.movingStrategy.RandomMove;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveTest {
    @Test
    @DisplayName("경계선값 3 또는 10 을 입력하면 false 를 반환한다")
    void movableFalse() {
        assertThat(new RandomMove(3).movable()).isFalse();
        assertThat(new RandomMove(10).movable()).isFalse();
    }

    @Test
    @DisplayName("경계선값 4 또는 9 을 입력하면 true 를 반환한다")
    void movableTrue() {
        assertThat(new RandomMove(4).movable()).isTrue();
        assertThat(new RandomMove(9).movable()).isTrue();
    }
}
