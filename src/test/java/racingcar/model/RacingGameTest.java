package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    RacingGame racingGame;
    List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = Lists.newArrayList(
                new Car("socar"),
                new Car("uber"),
                new Car("bmw")
        );
        racingGame = new RacingGame(carList);
    }


    @Test
    @DisplayName("Racing 전진 동작 테스트")
    void racingCanGoTest() {
        Car testCar = new Car("testCar");

        for (int i=0; i<10; i++) {
            Integer raceNumber = Randoms.pickNumberInRange(0, 3);
            racingGame.racing(testCar, raceNumber);
        }

        Assertions.assertThat(testCar.getGoCount())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("Racing 전진불가 동작 테스트")
    void racingCannotGoTest() {
        Car testCar = new Car("testCar");

        for (int i=0; i<10; i++) {
            Integer raceNumber = Randoms.pickNumberInRange(4, 9);
            racingGame.racing(testCar, raceNumber);
        }

        Assertions.assertThat(testCar.getGoCount())
                .isEqualTo(10);
    }

    @Test
    @DisplayName("RacingGame 정상 동작 테스트")
    void racingGameToalTest() {
        racingGame.start(10);
        for (Car car : carList) {
            car.printRecord();
        }
    }
}