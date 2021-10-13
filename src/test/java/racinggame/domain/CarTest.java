package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 이동하지_않는다(int gasPoint) {
        Car car = new Car(new CarName("gaeul"));
        car.move(gasPoint);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 이동한다(int gasPoint) {
        Car car = new Car(new CarName("gaeul"));
        car.move(gasPoint);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}