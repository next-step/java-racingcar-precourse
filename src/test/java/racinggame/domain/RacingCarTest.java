package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @ParameterizedTest(name = "입력받은 자동차 이름으로 자동차 객체를 생성한다")
    @ValueSource(strings = {"pobi"})
    void 입력받은_자동차_이름으로_자동차_객체를_생성한다(String racingCarNameInput) {
        RacingCar car = new RacingCar(racingCarNameInput);

        assertThat(car.getCarName()).isEqualTo(racingCarNameInput);
        assertThat(car.getMovesCount()).isEqualTo(0);
    }
}
