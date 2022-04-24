package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    public void create_car_test() {
        Car car = new Car("car");
        assertThat(car).isEqualTo(new Car("car"));
    }

    @Test
    public void car_move_test() {
        Car car = new Car("car");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void car_name_test() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }
}
