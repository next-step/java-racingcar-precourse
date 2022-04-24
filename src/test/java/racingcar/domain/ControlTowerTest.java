package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.MockControlTower;

import java.util.Observer;

public class ControlTowerTest {
    @Test
    void 컨트롤타워는_Observer_이다() {
        Assertions.assertTrue(new ControlTower(new Cars()) instanceof Observer);
    }

    @Test
    void 컨트롤타워는_Observable_에게_상태를_전달받는다() {
        Car carA = new Car(new CarName("A"));
        Cars cars = new Cars();
        cars.add(carA);
        MockControlTower controlTower = new MockControlTower(cars);
        Assertions.assertFalse(controlTower.isReceivedObservable());

        carA.drive();

        Assertions.assertTrue(controlTower.isReceivedObservable());
    }
}
