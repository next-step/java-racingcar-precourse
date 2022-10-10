package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarListTest {

    @Test
    @DisplayName("Car List 생성 확인")
    void createCar() {
        CarList carList = CarList.from("CAR_1,CAR_2");

        assertAll(
                () -> assertThat(carList.getCarList().size()).isEqualTo(2),
                () -> assertThat(carList.getCarList().get(0).getName()).isEqualTo("CAR_1"),
                () -> assertThat(carList.getCarList().get(1).getName()).isEqualTo("CAR_2"),
                () -> assertThat(carList.getCarList().get(0).getPosition()).isEqualTo(0),
                () -> assertThat(carList.getCarList().get(1).getPosition()).isEqualTo(0)
        );
    }
}
