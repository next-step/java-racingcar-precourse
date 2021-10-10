package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racinggame.utils.RacingGameUtils.*;

public class RacingCarTest {
    @ParameterizedTest(name = "입력받은 자동차 이름으로 자동차 객체를 생성한다")
    @ValueSource(strings = {"pobi"})
    void 입력받은_자동차_이름으로_자동차_객체를_생성한다(String racingCarNameInput) {
        RacingCar car = new RacingCar(racingCarNameInput);

        assertThat(car.getRacingCarName()).isEqualTo(racingCarNameInput);
        assertThat(car.getMovesCount()).isEqualTo(0);
    }

    @ParameterizedTest(name = "자동차 이름 검증이 완료되면, 자동차 리스트를 생성하고 반환한다")
    @CsvSource(value = {"pobi,crong,honux:3"}, delimiter = ':')
    void 자동차_이름_검증이_완료되면_자동차_리스트를_생성하고_반환한다(String racingCarNameInput, int sizeInput) {
        RacingCars racingCars = new RacingCars(getRacingCarList(racingCarNameInput));

        assertThat(racingCars.getRacingCars()).isInstanceOf(List.class);
        assertThat(racingCars.getRacingCars().size()).isEqualTo(sizeInput);
    }

    @ParameterizedTest(name = "자동차 경주 결과를 출력한다")
    @ValueSource(strings = {"pobi,crong,honux"})
    void 자동차_경주_결과를_출력한다(String racingCarNameInput) {
        RacingCars racingCars = new RacingCars(getRacingCarList(racingCarNameInput));

        List<RacingCar> racingCarList = racingCars.getRacingCars();
        /* 1회 */
        racingCarList.get(0).move();
        racingCarList.get(1).stop();
        racingCarList.get(2).stop();
        /* 2회 */
        racingCarList.get(0).move();
        racingCarList.get(1).move();
        racingCarList.get(2).stop();

        racingCarList.forEach(System.out::println);

        assertThat(racingCarList.get(0).toString()).isEqualTo("pobi : --");
        assertThat(racingCarList.get(1).toString()).isEqualTo("crong : -");
        assertThat(racingCarList.get(2).toString()).isEqualTo("honux : ");
    }
}
