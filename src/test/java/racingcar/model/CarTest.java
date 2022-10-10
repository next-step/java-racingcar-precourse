package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차이름_입력받아_자동차_만들기() {
        Car car = new Car(new CarName("빨간차"));
        assertEquals(car.getCarName(), "빨간차");
    }

    @Test
    void 자동차이름_여러개_입력받아_자동차들_만들기() {
        Cars cars = new Cars(Arrays.asList("빨간차", "노란차"));
        assertEquals(cars.length(), 2);
    }

    @Test
    void 유효하지않은_자동차이름_입력받아_에러내기() {
        assertThrows(IllegalArgumentException.class, () -> new Cars(Arrays.asList("빨간차", "노란차차차설운도차차차")));
    }

    @Test
    void 자동차_정지() {
        Car car1 = new Car(new CarName("빨간차"), new Drive(() -> 0));
        car1.drive();
        assertEquals(car1.getPosition(), Drive.STOP_POINT);

        Car car2 = new Car(new CarName("빨간차"), new Drive(() -> Drive.MOVE_DECIDE_STANDARD_NUMBER - 1));
        car2.drive();
        assertEquals(car2.getPosition(), Drive.STOP_POINT);
    }

    @Test
    void 자동차_진행() {
        Car car1 = new Car(new CarName("빨간차"), new Drive(() -> 9));
        car1.drive();
        assertEquals(car1.getPosition(), Drive.MOVE_POINT);

        Car car2 = new Car(new CarName("빨간차"), new Drive(() -> Drive.MOVE_DECIDE_STANDARD_NUMBER));
        car2.drive();
        car2.drive();
        assertEquals(car2.getPosition(), Drive.MOVE_POINT * 2);
    }
}
