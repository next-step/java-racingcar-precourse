package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @Test
    void 자동차_이름_입력() {
        String carNameList = "car1,car2,car3";
        Cars cars = new Cars();
        cars.generateCars(carNameList);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("car1");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("car2");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("car3");
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 자동차_이름_예외_empty() {
        assertThrows(IllegalArgumentException.class, () -> {
            String carNameList = ", ";
            Cars cars = new Cars();
            cars.generateCars(carNameList);
        });
    }

    @Test
    void 자동차_이름_예외_자리수() {
        assertThrows(IllegalArgumentException.class, () -> {
            String carNameList = "car,123456";
            Cars cars = new Cars();
            cars.generateCars(carNameList);
        });
    }

    @Test
    void 자동차_이름_예외_중복() {
        assertThrows(IllegalArgumentException.class, () -> {
           String carNameList = "car1,car1";
            Cars cars = new Cars();
            cars.generateCars(carNameList);
        });
    }
}
