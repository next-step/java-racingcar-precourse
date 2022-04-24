package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {

    private Car shinCar = new Car(new CarName("shin"));
    private Car hanCar = new Car(new CarName("han"));

    @Test
    void 레이싱_결과_검증() {
        Cars cars = new Cars(Arrays.asList(shinCar, hanCar));
        RacingResult racingResult = cars.moveCars(Arrays.asList(5, 2));

        StringBuilder compareResult = new StringBuilder();
        compareResult.append("shin : -\n")
                .append("han : \n");

        assertThat(racingResult.raceTurnResult().toString().trim()).isEqualTo(compareResult.toString().trim());
    }
}