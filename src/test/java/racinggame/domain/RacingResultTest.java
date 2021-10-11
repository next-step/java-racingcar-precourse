package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {

    private Car shinCar = new Car(new CarName("shin"));
    private Car hanCar = new Car(new CarName("han"));

    @Test
    @DisplayName("레이싱 턴에 대한 결과를 출력한다")
    void print_racing_result() {
        Cars cars = new Cars(Arrays.asList(shinCar, hanCar));
        RacingResult racingResult = cars.moveCars(Arrays.asList(5, 2));

        StringBuilder compareResult = new StringBuilder();
        compareResult.append("shin : -\n")
                .append("han : \n");

        assertThat(racingResult.getTurnResult()).isEqualTo(compareResult.toString());
    }
}