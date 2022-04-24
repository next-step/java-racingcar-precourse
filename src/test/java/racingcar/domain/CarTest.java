package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.MockCar;

import java.util.Observable;

public class CarTest {
    @Test
    void 차는_차_이름을_갖는_Obervable_객체이다() {
        CarName carName = new CarName("차이름");
        Car car = new Car(carName);
        Assertions.assertTrue(car instanceof Observable);
    }

    @Test
    void 차는_동작을_옵저버에게_알린다() {
        MockCar car = new MockCar(new CarName("mock"));
        Assertions.assertFalse(car.isNotifyObserversCalled());

        car.drive();

        Assertions.assertTrue(car.isNotifyObserversCalled());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "12345", "     ", "*", "#$%^$", "😀", "😀😀"})
    void 차는_차_이름이_같으면_같은_객체라고_생각한다(String input) {
        CarName carName = new CarName(input);
        Assertions.assertEquals(new Car(carName), new Car(carName));
    }
}
