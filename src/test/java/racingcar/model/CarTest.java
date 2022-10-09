package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    Car car;

    @BeforeEach
    void init() {
        car = new Car(Name.valueOf("car1"));
    }

    @Test
    void car_이동() {
        car.move();
        Position position = car.getPosition();
        assertThat(position.get()).isEqualTo(1);
    }

    @Test
    void 숫자가_4이상인_경우에만_이동() {
        assertThat(car.isMovable(4)).isTrue();
        assertThat(car.isMovable(3)).isFalse();
    }
}
