package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    String testName = "TEST";

    @Test
    public void carTest() {
        Car car = Car.withName(testName);
        assertThat(car.getName()).isEqualTo(testName);
        car.update();

        System.out.println(car.getLaps());
    }
}
