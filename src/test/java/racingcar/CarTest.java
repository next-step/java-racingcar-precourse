package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_전진() {
        String name = "test";
        Car car = Car.create(name);
        car.moveForward();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값_기준값_이상_자동차_전진() {
        String name = "test";
        int no = CarProperties.LEAST_NUM_TO_MOVE;
        Car car = Car.create(name);
        car.canMoveForward(no);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
