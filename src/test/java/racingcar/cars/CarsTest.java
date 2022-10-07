package racingcar.cars;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class CarsTest {

    private Cars cars;
    String input = "pobi,javaj,crong,honux";

    @BeforeEach
    void beforeEach() throws IllegalArgumentException {
        cars = Cars.generateRacingCarsFromInputString(input);
    }

    @Test
    void 자동차_이름_입력() throws IllegalArgumentException {
        List<Car> racingCarList = cars.getCars();

        assertAll(
                () -> Assertions.assertThat(racingCarList.get(0).getName()).isEqualTo("pobi"),
                () -> Assertions.assertThat(racingCarList.get(1).getName()).isEqualTo("javaj"),
                () -> Assertions.assertThat(racingCarList.get(2).getName()).isEqualTo("crong"),
                () -> Assertions.assertThat(racingCarList.get(3).getName()).isEqualTo("honux")
        );
    }

    @Test
    void 자동차_우승자_프린트_위치기준() {
        cars.getCars().get(2).setLocation(true);
        cars.getCars().get(2).setLocation(true);
        cars.getCars().get(3).setLocation(true);
        cars.getCars().get(3).setLocation(true);
        Assertions.assertThat(cars.filterWinner()).isEqualTo("crong, honux");
    }
}
