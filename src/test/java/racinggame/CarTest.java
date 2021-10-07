package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.car.Car;

import javax.naming.LimitExceededException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    @Test
    void carConstructorTest() {
        assertThatExceptionOfType(LimitExceededException.class).isThrownBy(
                () -> {
                    Car car = new Car("qwerty");
                }
        );
    }

    @Test
    void carGoTest() throws Exception {
        Car car = new Car("aba");
        car.go(4);
        assertThat(car.getCarProgress().get()).isEqualTo(1);
        car.go(3);
        assertThat(car.getCarProgress().get()).isEqualTo(1);
    }
}
