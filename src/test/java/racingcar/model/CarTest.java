package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @DisplayName("랜덤값이 4이상일때 자동차 전진 테스트")
    @Test
    void 랜덤값이_4이상일때_자동차_전진_테스트() {
        Car car = new Car(new CarName("test"));

        car.run(4);

        assertEquals(car.getDistance().getDistanceValue(), 1);
    }

    @DisplayName("3 이하일때 자동차 멈춤 테스트")
    @Test
    void 값이_3이하일때_자동차_멈춤_테스트() {
        Car car = new Car(new CarName("test"));

        car.run(0);

        assertEquals(car.getDistance().getDistanceValue(), 0);
    }

    @DisplayName("자동차 distance 출력 테스트")
    @Test
    void 자동차_distance_출력_테스트() {
        Car car = new Car(new CarName("test"));

        car.run(4);
        car.run(5);

        assertEquals(car.toStringCarDistance(), "test : --");
    }
}
