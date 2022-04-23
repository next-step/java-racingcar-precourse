package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 자동차_움직임_테스트() {
        RacingCar racingCar = new RacingCar(new RacingCarName("a"));

        racingCar.move();
        racingCar.move();
        racingCar.move();

        assertEquals("a : ---", racingCar.toString());
    }

    @Test
    void 자동차_인스턴스_비교_테스트() {
        RacingCar car1 = new RacingCar(new RacingCarName("a"));
        RacingCar car2 = new RacingCar(new RacingCarName("a"));

        assertEquals(car1, car2);
    }

    @Test
    void 객체_복사_테스트() {
        RacingCar car = new RacingCar(new RacingCarName("a"));
        RacingCar car1 = RacingCar.newInstance(car);

        assertEquals(car, car1);
    }

}