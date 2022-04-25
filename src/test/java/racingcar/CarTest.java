package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_이름_부여() {
        Car car = new Car("pjh");
        assertThat(car.getName()).isEqualTo("pjh");
    }

    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("pjh");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
