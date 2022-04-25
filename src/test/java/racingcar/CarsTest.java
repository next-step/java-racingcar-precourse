package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("차 이름 리스트를 넣으면 차가 이름 리스트의 갯수 만큼 생성된다.")
    void createCars() {
        // given
        String userInput = "poly,ply,fly";
        CarNames carNames = CarNames.getCarNamesFromInput(userInput);

        // when
        Cars cars = Cars.createCars(carNames);

        // then
        assertThat(cars.getCars().size()).isEqualTo(carNames.getCarNames().size());
    }
}
