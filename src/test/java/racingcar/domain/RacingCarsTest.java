package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc,null,test"})
    void 레이싱_자동차_설정(String input) {
        String[] names = input.split(",");

        for (String name : names) {
            RacingCar racingCar = new RacingCar(new RacingCarName(name));
            racingCars.addRacingCar(racingCar);
        }

        // then
        Assertions.assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
    }
}
