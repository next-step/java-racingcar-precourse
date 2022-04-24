package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.MockCar;

class CarsTest {
    @Test
    public void 차들에게_운전_명령을_내릴_수_있다() {
        Cars cars = new Cars();
        MockCar mockCar1 = new MockCar(new CarName("mock1"));
        MockCar mockCar2 = new MockCar(new CarName("mock2"));
        cars.add(mockCar1);
        cars.add(mockCar2);

        Assertions.assertFalse(mockCar1.isNotifyObserversCalled());
        Assertions.assertFalse(mockCar2.isNotifyObserversCalled());

        cars.driveAll();

        Assertions.assertTrue(mockCar1.isNotifyObserversCalled());
        Assertions.assertTrue(mockCar2.isNotifyObserversCalled());
    }

    @Test
    public void 차들은_중복된_이름을_가질_수_없다() {
        Cars cars = new Cars();
        MockCar mockCar1 = new MockCar(new CarName("mock1"));
        MockCar mockCar2 = new MockCar(new CarName("mock1"));
        cars.add(mockCar1);

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> cars.add(mockCar2));
    }

}
