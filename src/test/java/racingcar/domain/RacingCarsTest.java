package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    String[] racingCarName;
    RacingCars racingCars;

    @BeforeEach
    public void create() {
        racingCarName = new String[]{"자동차1", "자동차2", "자동차3"};
        racingCars = new RacingCars(racingCarName);
    }

    @Test
    void RacingCars_객체_생성_테스트() {
        for (int index = 0; index < racingCarName.length; index++) {
            assertThat(racingCarName[index]).isEqualTo(racingCars.getNameByIndex(index + 1));
            assertThat(0).isEqualTo(racingCars.getGoCountByIndex(index + 1));
        }
    }

    @Test
    void 자동차_객체_가져오기() {
        RacingCar racingCar = new RacingCar("자동차1");
        assertThat(racingCar).usingRecursiveComparison().isEqualTo(racingCars.getRacingCarByIndex(1));
        racingCar = new RacingCar("자동차2");
        assertThat(racingCar).usingRecursiveComparison().isEqualTo(racingCars.getRacingCarByIndex(2));
        racingCar = new RacingCar("자동차3");
        assertThat(racingCar).usingRecursiveComparison().isEqualTo(racingCars.getRacingCarByIndex(3));
    }
}
