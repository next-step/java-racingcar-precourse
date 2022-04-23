package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CarsTest {

    @Test
    @DisplayName("승자 구하기 검증 - 한 명의 승자")
    public void getWinners_oneWinner() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("car1", 10));
        carList.add(new Car("car2", 7));
        carList.add(new Car("car3", 8));
        Cars cars = new Cars(carList);

        assertThat(cars.getWinners()).isEqualTo("car1");
    }

    @Test
    @DisplayName("승자 구하기 검증 - 한 명 이상의 승자")
    public void getWinners_moreThanOneWinner() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("car1", 10));
        carList.add(new Car("car2", 10));
        carList.add(new Car("car3", 8));
        Cars cars = new Cars(carList);

        assertThat(cars.getWinners()).isEqualTo("car1, car2");
    }

}