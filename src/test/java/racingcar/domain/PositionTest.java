package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import racingcar.enums.Action;

class PositionTest {

    private Position position;

    @Test
    void 포지션_검증() {
        position = new Position(2);
        assertThat(position.getCarPosition()).isEqualTo(2);
    }

    @Test
    void 포지션_음수_예외() {
        assertThrows(IllegalStateException.class, () -> new Position(-1));
    }

    @Test
    void 포지션_이동_테스트() {
        position = new Position(0);
        position.addCarPosition(Action.STOP);
        assertThat(position.getCarPosition()).isEqualTo(0);
        position.addCarPosition(Action.MOVE);
        assertThat(position.getCarPosition()).isEqualTo(1);
        position.addCarPosition(Action.MOVE);
        position.addCarPosition(Action.MOVE);
        assertThat(position.getCarPosition()).isEqualTo(3);
    }

}