package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceRuleTest {

    @Test
    @DisplayName("입력 값에 따라 전진")
    void goTest() {
        int randomNumber = 4;
        Car car = new Car("test", 0);
        car.move(randomNumber);

        assertEquals(car.getDistance(), new Distance(1));
    }

    @Test
    @DisplayName("입력 값에 따라 제자리")
    void stayTest() {
        int randomNumber = 3;
        Car car = new Car("test", 0);
        car.move(randomNumber);

        assertEquals(car.getDistance(), new Distance(0));
    }
}
