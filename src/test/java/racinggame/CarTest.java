package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void car_move_test() {
        Car car = new Car("boss");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
