package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {

    @Test
    void move() {
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(initialPosition);
    }

    @Test
    void getPosition() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
        car.move();
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void getName() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void createCar() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

}