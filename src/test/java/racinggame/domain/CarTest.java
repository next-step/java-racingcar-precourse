package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차의_이동하는지_톄스트() {
        Car actual = new Car("machine", 1);
        Location expectedLocation = new Location(2);

        actual.moveCar(CarMove.MOVE);

        assertThat(actual.getLocation()).isEqualTo(expectedLocation);
    }

    @Test
    void 자동차가_멈춰있는지_테스트() {
        Car actual = new Car("machine", 1);
        Location expectedLocation = new Location(1);

        actual.moveCar(CarMove.STOP);

        assertThat(actual.getLocation()).isEqualTo(expectedLocation);
    }
}
