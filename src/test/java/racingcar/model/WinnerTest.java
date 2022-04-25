package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private Car kiaCar = new Car(new CarName("kia"));
    private Car huyndaiCar = new Car(new CarName("huyn"));

    @Test
    @DisplayName("최종 우승자 테스트")
    void 최종_우승자_테스트() {
        Cars cars = new Cars(Arrays.asList(kiaCar, huyndaiCar));

        cars.move(Arrays.asList(8, 2));

        Winner winner = new Winner(cars.getCars());
        assertThat(winner.searchFinalWinningCars()).isEqualTo("kia");

    }
}