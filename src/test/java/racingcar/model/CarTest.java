package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_생성() {
        Car car = new Car("sam");
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("sam");
    }

    @Test
    void 자동차_이동_0_9_검증() {
        Car car = new Car("sam");

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(9);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 자동차_정지_0_9_검증() {
        Car car = new Car("sam");
        car.move(0);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}