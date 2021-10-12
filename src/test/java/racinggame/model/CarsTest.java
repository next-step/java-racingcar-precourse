package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("자동차 이름 입력 성공")
    void 자동차_이름_입력() {
        Cars cars = new Cars("car0,car1,car2,car3");
        assertThat(cars.getCarsLength()).isEqualTo(4);
        assertThat(cars.getCarList().get(0).getName()).isEqualTo("car0");
        assertThat(cars.getCarList().get(3).getName()).isEqualTo("car3");
    }

    @Test
    @DisplayName("자동차 이름 입력 실패")
    void 자동차_이름_입력_실패() {
        assertThatThrownBy(() -> new Cars("car0,car111,car2,car3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("우승자 선정 1명")
    void 우승자_선정_1명() {
        Cars cars = new Cars("car0,car1,car2,car3");
        cars.getCarList().get(0).move(CarStatus.GO);
        cars.getCarList().get(0).move(CarStatus.STOP);
        cars.getCarList().get(1).move(CarStatus.GO);
        cars.getCarList().get(1).move(CarStatus.GO);
        cars.getCarList().get(2).move(CarStatus.STOP);
        cars.getCarList().get(2).move(CarStatus.GO);
        cars.getCarList().get(3).move(CarStatus.STOP);
        cars.getCarList().get(3).move(CarStatus.STOP);

        List<Car> winnerCarList = cars.getWinnerCarList();

        assertThat(winnerCarList.get(0).getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("우승자 선정 2명이상")
    void 우승자_선정_2명이상() {
        Cars cars = new Cars("car0,car1,car2,car3");
        cars.getCarList().get(0).move(CarStatus.GO);
        cars.getCarList().get(0).move(CarStatus.STOP);
        cars.getCarList().get(1).move(CarStatus.GO);
        cars.getCarList().get(1).move(CarStatus.GO);
        cars.getCarList().get(2).move(CarStatus.GO);
        cars.getCarList().get(2).move(CarStatus.GO);
        cars.getCarList().get(3).move(CarStatus.STOP);
        cars.getCarList().get(3).move(CarStatus.STOP);

        List<Car> winnerCarList = cars.getWinnerCarList();

        assertThat(winnerCarList.get(0).getName()).isEqualTo("car1");
        assertThat(winnerCarList.get(1).getName()).isEqualTo("car2");
    }
}
