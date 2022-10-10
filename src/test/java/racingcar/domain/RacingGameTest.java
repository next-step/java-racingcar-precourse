package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.util.CarUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @Test
    void 입력받은값으로_자동차객체들_생성() {
        RacingGame racingGame = new RacingGame(() -> true);
        String carNameString = "asd,zxc,qwe";
        racingGame.createCars(CarUtil.createCarsOf(carNameString));
    }

    @Test
    void 사용자입력값에따라_자동차들이_움직인다() {
        RacingGame racingGame = new RacingGame(() -> true);

        String carNamesString = "asd,zxc,qwe";
        List<Car> cars = CarUtil.createCarsOf(carNamesString);
        racingGame.createCars(cars);
        racingGame.moveCars();
        for (Car car : cars) {
            assertEquals(car.getCurrentPositon(), new Position(1));
        }
    }

}