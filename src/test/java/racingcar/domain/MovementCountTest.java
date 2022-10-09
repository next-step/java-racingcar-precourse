package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementCountTest {

    @Test
    @DisplayName("자동차_전진")
    void 자동차_전진() {
        Integer moveNumber = 4;
        MovementCount movementCount = new MovementCount();
        movementCount.move(moveNumber);
        assertThat(movementCount.getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차_멈춤")
    void 자동차_멈춤() {
        Integer moveNumber = 3;
        MovementCount movementCount = new MovementCount();
        movementCount.move(moveNumber);
        assertThat(movementCount.getCount()).isEqualTo(0);
    }
}
