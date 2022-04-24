package racingcar.damain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void tryoutMove() {
        car = new Car("happy");

        assertThat(car.getCarName()).isEqualTo("happy");
        assertThat(car.getPosition()).isEqualTo(0);

        assertRandomNumberInRangeTest(
            () -> {
                car.tryoutMove();
                car.tryoutMove();
                car.tryoutMove();
                assertThat(car.getPosition()).isEqualTo(2);
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}