package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveStatusTest {

    @Test
    @DisplayName("전진_검증")
    void 전진_검증() {
        Car car = new Car("test", 0);

        assertThat(Racing.goOrStop(9)).isEqualTo(MoveStatus.GO);
    }

    @Test
    @DisplayName("멈춤_검증")
    void 멈춤_검증() {
        Car car = new Car("test", 0);

        assertThat(Racing.goOrStop(3)).isEqualTo(MoveStatus.STOP);
    }
}