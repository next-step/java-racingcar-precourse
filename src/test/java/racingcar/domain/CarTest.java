package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차이름을_입력받아_자동차객체를_생성한다() {
        CarName carName = new CarName("a");
        Car car = new Car(carName);
    }

    @Test
    void 자동차이름은_1자이상_5자이하이다() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CarName("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new CarName("asdasdasd");
        });
    }

    @Test
    void 랜덤값이_3이하면_멈추고_4이상이면_전진한다() {
        Car car = new Car(new CarName("dongk"));
        car.move(() -> false);
        assertEquals(car.getCurrentPositon(), new Position());

        car.move(() -> true);
        assertEquals(car.getCurrentPositon(), new Position(1));
    }
}