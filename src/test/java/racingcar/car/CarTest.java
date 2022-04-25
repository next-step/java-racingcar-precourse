package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.strategy.MovingStrategy;

class CarTest {

    CarFactory factory;

    @Test
    @DisplayName("자동차가 이동하면, location이 1 증가한다.")
    public void carMoveTest() {
        factory = new CarFactory(() -> true);
        Car car = factory.createCar(new CarName("dsa"));
        car.tryMove();
        CarLocation location = car.location();
        assertThat(location.getLocation())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 이동하지 않으면, location이 증가하지 않는다.")
    public void carNoMoveTest() {
        factory = new CarFactory(() -> false);
        Car car = factory.createCar(new CarName("dsa"));
        car.tryMove();
        CarLocation location = car.location();
        assertThat(location.getLocation())
                .isEqualTo(0);
    }
}