package racingcar.model.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    @Test
    @DisplayName("입력받아서 ,기준으로 분리하여 자동차 리스트를 생성하고 그 리스트의 사이즈는 3이다.")
    void 자동차이름_입력받아서_자동차_리스트_사이즈3_객체생성() {
        //given
        Cars cars = new Cars();

        //when
        List<CarName> carNames = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));
        cars.createCarList(carNames);

        //then
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 레이스를 호출하면 자동차리스트에 있는 각 자동차객체에 distance 랜덤값이 입력된다. " +
            "RANDOM값이 4,3이면 distance는 1,0이다")
    void 자동차레이스_기능() {
        //given
        Cars cars = new Cars();

        //then
        assertRandomNumberInRangeTest(
                () -> {
                    //when
                    List<CarName> carNames = Arrays.asList(new CarName("test1"), new CarName("test2"));
                    cars.createCarList(carNames);
                    cars.race();

                    //then
                    Assertions.assertThat(cars.getCars().get(0).getDistance()).isEqualTo(1);
                    Assertions.assertThat(cars.getCars().get(0).getPosition()).isEqualTo("-");
                    Assertions.assertThat(cars.getCars().get(1).getDistance()).isEqualTo(0);
                    Assertions.assertThat(cars.getCars().get(1).getPosition()).isEqualTo("");
                },
                4, 3
        );
    }

    @Test
    @DisplayName("자동차 리스트가 test1,test2이고 RANDOM값이 4,3이면 우승자는 test1이다.")
    void 자동차_우승자_구하기_기능() {
        //given
        Cars cars = new Cars();

        //then
        assertRandomNumberInRangeTest(
                () -> {
                    //when
                    List<CarName> carNames = Arrays.asList(new CarName("test1"), new CarName("test2"));
                    cars.createCarList(carNames);
                    cars.race();

                    //then
                    Assertions.assertThat(cars.getWinnners().get(0).getName()).isEqualTo("test1");
                },
                4, 3
        );
    }

}
