package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {


    @Test
    @DisplayName("레이싱 단독우승 검증")
    void soloWinning(){
        String carsString = "one,two,three";
        Cars cars = new Cars(carsString);
        cars.getCarList().get(0).getCarPosition().setPosition(2);
        cars.getCarList().get(1).getCarPosition().setPosition(3);
        cars.getCarList().get(2).getCarPosition().setPosition(0);
        RacingResult racingResult = new RacingResult(cars);
        assertThat(racingResult.getWinningCarNameList().get(0).getCarName().getName()).isEqualTo(cars.getCarList().get(1).getCarName().getName());
    }

    @Test
    @DisplayName("레이싱 여러 자동차우승 검증")
    void multipleWinning(){
        String carsString = "one,two,three";
        Cars cars = new Cars(carsString);
        cars.getCarList().get(0).getCarPosition().setPosition(2);
        cars.getCarList().get(1).getCarPosition().setPosition(3);
        cars.getCarList().get(2).getCarPosition().setPosition(3);
        RacingResult racingResult = new RacingResult(cars);
        assertThat(racingResult.getWinningCarNameList().get(0).getCarName().getName()).isEqualTo(cars.getCarList().get(1).getCarName().getName());
        assertThat(racingResult.getWinningCarNameList().get(1).getCarName().getName()).isEqualTo(cars.getCarList().get(2).getCarName().getName());
    }

}
