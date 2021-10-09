package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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
        List<RacingCar> racingCarList = new ArrayList<>();

        String[] racingCarNameSplit = racingCarNameSplit(racingCarNameInput);
        for (String racingCarName : racingCarNameSplit) {
            racingCarList.add(new RacingCar(racingCarName));
        }

        RacingCars racingCars = new RacingCars(racingCarList);

        assertThat(racingCars.getRacingCars()).isInstanceOf(List.class);
        assertThat(racingCars.getRacingCars().size()).isEqualTo(sizeInput);
    }
}
