package racingcar.rounds;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.cars.Cars;

import static org.junit.jupiter.api.Assertions.assertAll;

public class RoundTest {

    private Cars cars;
    String input = "pobi,javaj,crong,honux";

    @BeforeEach
    void beforeEach() throws IllegalArgumentException {
        cars = Cars.generateRacingCarsFromInputString(input);
    }

    @Test
    void 라운드_객체_생성() {
        Round round = new Round(cars, 2);
        Cars thisRoundCars = round.getCars();
        assertAll(
                () -> Assertions.assertThat(thisRoundCars.getCars().get(0).getName()).isEqualTo("pobi"),
                () -> Assertions.assertThat(thisRoundCars.getCars().get(1).getName()).isEqualTo("javaj"),
                () -> Assertions.assertThat(thisRoundCars.getCars().get(2).getName()).isEqualTo("crong"),
                () -> Assertions.assertThat(thisRoundCars.getCars().get(3).getName()).isEqualTo("honux"),
                () -> Assertions.assertThat(round.getCurrentRoundCount()).isEqualTo(2)
        );
    }
}
