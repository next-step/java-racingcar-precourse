package racingcar.model.cars.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.model.cars.Car;

public class CarFactoryTest {
    @Test
    void 자동차_생산() {
        String carName = "자동차이름";
        Car car = CarFactory.create(new Title(carName));

        assertThat(car.getTitle().get()).isEqualTo(carName);
        assertThat(car.getMoveHistory().get()).isEqualTo(new ArrayList<>());
    }
}
