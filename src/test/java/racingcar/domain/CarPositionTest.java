package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    @Test
    @DisplayName("차량 위치")
    void position() {
        CarPosition position = new CarPosition();
        assertThat(position.getPosition()).isEqualTo(0);

        position.move(MoveStatus.MOVE);
        assertThat(position.getPosition()).isEqualTo(1);

        position.move(MoveStatus.STOP);
        assertThat(position.getPosition()).isEqualTo(1);

        position.move(MoveStatus.MOVE);
        assertThat(position.getPosition()).isEqualTo(2);
    }

}