package racingcar.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @DisplayName("입력받은 이름으로 자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni"})
    void input_new_car(String carName) {
        CarNames carNames = new CarNames(carName);
        Cars cars = new Cars(carNames);

        assertThat(cars.getCarList().get(0).getCarName()).isEqualTo("pobi");
        assertThat(cars.getCarList().get(1).getCarName()).isEqualTo("woni");
    }

    @DisplayName("자동차 현재 위치값")
    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    void cars_postion(String carName) {
        CarNames carNames = new CarNames(carName);
        Cars cars = new Cars(carNames);
        for (int i = 0 ; i < 2 ; i ++ ) {
            cars.getCarList().get(0).move(4);
        }
        assertThat(cars.getCarList().get(0).getPosition()).isEqualTo(2);
    }

    @DisplayName("자동차 우승자 위치")
    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    void cars_winner(String carName) {
        CarNames carNames = new CarNames(carName);
        Cars cars = new Cars(carNames);
        for (int i = 0 ; i < 2 ; i ++ ) {
            cars.moveCars();
        }
        assertTrue(cars.getWinnerList().get(0).isWinner());
    }



}
