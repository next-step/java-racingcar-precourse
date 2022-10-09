package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @DisplayName("포지션을 증가시킨다.")
    @Test
    void position_increase() {
        Position position = new Position();
        position.increase();

        assertThat(position.get()).isEqualTo(1);
    }

}
