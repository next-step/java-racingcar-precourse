package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void injectEnergy_shouldForwardWhenGreaterThanFour() {
        Car car = new Car("abc");

        car.injectEnergy(new Energy(4));

        assertThat(car.getMileage()).isEqualTo(new Mileage(1));
    }

    @Test
    void injectEnergy_shouldStopWhenLessThanFour() {
        Car car = new Car("abc");

        car.injectEnergy(new Energy(3));

        assertThat(car.getMileage()).isEqualTo(new Mileage());
    }
}
