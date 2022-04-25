package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @DisplayName("랜덤값이 4이상일때 자동차 전진 테스트")
    @Test
    void forwardCarTest() {
        Car car = new Car(new CarName("test"));

        car.run(4);

        assertEquals(car.getDistance().getDistanceValue(), 1);
    }

    @DisplayName("3 이하일때 자동차 멈춤 테스트")
    @Test
    void stopCarTest() {
        Car car = new Car(new CarName("test"));

        car.run(0);

        assertEquals(car.getDistance().getDistanceValue(), 0);
    }

    @DisplayName("자동차 distance 출력 테스트")
    @Test
    void matchDistancePrint() {
        Car car = new Car(new CarName("test"));

        car.run(4);
        car.run(5);

        assertEquals(car.toStringCarDistance(), "test : --");
    }
}
