package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class CarsTest {

    @Test
    @DisplayName("입력된 문자열을 쉼표로 분리하여 car객체에 잘 담기는지 확인.")
    void createCars() {

        String carsString = "one,two,three";
        Cars cars = new Cars(carsString);

        assertAll(
                () -> assertThat(cars.getCarList().get(0).getCarName().getName()).isEqualTo("one"),
                () -> assertThat(cars.getCarList().get(1).getCarName().getName()).isEqualTo("two"),
                () -> assertThat(cars.getCarList().get(2).getCarName().getName()).isEqualTo("three")
        );
    }

}
