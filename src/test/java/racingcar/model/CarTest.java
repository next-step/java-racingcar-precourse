package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    void setup() {
        car = new Car(new CarName("sss"));
    }

    @Test
    void 자동차_전진_검증() {
        car.moveForward(CarStatus.GO);

        assertThat(car.getPosition()).isEqualTo("-");
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차_이름_검증() {
        CarName carName = new CarName("sss");

        assertThat(car.getName().getName()).isEqualTo("sss");
    }

}
