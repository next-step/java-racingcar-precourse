package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MovementTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("값이 4 이상인 경우 전진한다.")
    void 랜덤_값_4_이상_전진() {
        MovementStatus movementStatus1 = car.move(new Movement(4));
        MovementStatus movementStatus2 = car.move(new Movement(9));

        assertThat(movementStatus1).isEqualTo(MovementStatus.GO);
        assertThat(movementStatus2).isEqualTo(MovementStatus.GO);
    }

    @Test
    @DisplayName("값이 3 이하인 경우 멈춘다.")
    void 랜덤_값_3_이하_멈춤() {
        MovementStatus movementStatus1 = car.move(new Movement(3));
        MovementStatus movementStatus2 = car.move(new Movement(0));

        assertThat(movementStatus1).isEqualTo(MovementStatus.STOP);
        assertThat(movementStatus2).isEqualTo(MovementStatus.STOP);
    }
}
