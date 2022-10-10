package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarListTest {
    @Test
    void 프로그램_실행결과_예시_테스트() {
        RacingCar pobi = new RacingCar(new RacingCarName("pobi"), new Location(5));
        RacingCar crong = new RacingCar(new RacingCarName("crong"), new Location(4));
        RacingCar honux = new RacingCar(new RacingCarName("honux"), new Location(5));

        List<RacingCar> newCars = new ArrayList<>();
        newCars.add(pobi);
        newCars.add(crong);
        newCars.add(honux);

        RacingCarList carList = new RacingCarList(newCars);
        Winners winners = carList.report();

        String resultStr = winners.getWinnersAsString();
        assertThat("pobi, honux").isEqualTo(resultStr);
    }
}
