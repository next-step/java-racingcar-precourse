package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;


class CarsTest {
    List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = Arrays.asList(new Car(4, "test"), new Car(3, "tom"), new Car(4, "jerry"));
    }

    @Test
    @DisplayName("차 중에 이름이 중복되는 차가 있는지 확인")
    void checkDuplicateCar() {
        carList = Arrays.asList(new Car("test"), new Car("test"));
        assertThatThrownBy(() -> {
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 같은 자동차가 있습니다.");
    }

    @Test
    @DisplayName("가장 선두에 있는 car list")
    void currentWinnerTest() {
        Cars cars = new Cars(carList);
        List<Car> winnerCars = cars.currentFirstCarList();
        assertAll(
                () -> assertThat(winnerCars.size()).isEqualTo(2),
                () -> assertThat(winnerCars.get(0).carName()).isEqualTo("test"),
                () -> assertThat(winnerCars.get(1).carName()).isEqualTo("jerry")
        );
    }

}
