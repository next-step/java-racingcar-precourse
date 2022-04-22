package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void moveCar() {
        Car car = new Car("pobi");
        car.moveCar(3);
        assertThat(car).usingRecursiveComparison().isEqualTo(new Car("pobi", 0));

        car.moveCar(4);
        assertThat(car).usingRecursiveComparison().isEqualTo(new Car("pobi", 1));
    }
}
