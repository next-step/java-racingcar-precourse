package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.CarConstant;
import racingcar.constant.Constant;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void isMoveTest() {
        Car car = Car.createCar("A");
        boolean result = car.matchMove(5);
        assertTrue(result);
    }

    @Test
    void isStopTest() {
        Car car = Car.createCar("A");
        boolean result = car.matchMove(3);
        assertFalse(result);
    }

    @Test
    void validateInputTryNumberTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CarNumber("10")
        );
    }

    @ParameterizedTest
    @DisplayName("distance 결과 검증")
    @CsvSource(value = {"1,1,1:0", "5,1,2:1", "9,8,1:2", "5,6,7:3"}, delimiter = ':')
    void validateExpectedDistanceTest(String input, String expected) {
        // given
        Car car = Car.createCar("yoon");
        // when
        String[] moveNumberArray = input.split(Constant.COLON)[0].split(CarConstant.COMMA);
        for (String number : moveNumberArray) {
            car.move(Integer.parseInt(number));
        }
        // then
        assertEquals(car.getDistance(), Integer.parseInt(expected));
    }
}
