package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    @Test
    void enterCarNameTest() {
        Car newCar = new Car("abcdef");
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(newCar::isCarNameCollect);
    }

    @Test
    void stopOrGoTest() {
        Car newCar = new Car("myCar");
        newCar.goOrStop(CarStatus.GO);
        assertThat(newCar.getMoveDistance()).isEqualTo(1);
    }

    @Test
    void printStatusTest() {
        Car newCar = new Car("myCar");
        while (newCar.getMoveDistance() <= 0) {
            newCar.goOrStop(CarStatus.GO);
        }

        assertThat(newCar.printStatusString()).contains("myCar", ":", "-");
    }
}
