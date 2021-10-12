package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingWinnersTest {
    @ParameterizedTest(name = "우승자 자동차 이름을 출력한다(공동 우승)")
    @ValueSource(strings = {"pobi,crong,honux"})
    void 우승자_자동차_이름을_출력한다_공동_우승(String racingCarNameInput) {
        RacingCars racingCars = new RacingCars(racingCarNameInput);
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        /* 1회 */
        racingCarList.get(0).movingForward();
        racingCarList.get(1).movingForward();
        racingCarList.get(2).stop();
        /* 2회 */
        racingCarList.get(0).movingForward();
        racingCarList.get(1).movingForward();
        racingCarList.get(2).stop();

        assertThat(new RacingWinners(racingCars.getWinners()).toString()).isEqualTo("최종 우승자는 pobi,crong 입니다.");
    }

    @ParameterizedTest(name = "우승자 자동차 이름을 출력한다")
    @ValueSource(strings = {"pobi,crong,honux"})
    void 우승자_자동차_이름을_출력한다(String racingCarNameInput) {
        RacingCars racingCars = new RacingCars(racingCarNameInput);
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        /* 1회 */
        racingCarList.get(0).movingForward();
        racingCarList.get(1).movingForward();
        racingCarList.get(2).stop();
        /* 2회 */
        racingCarList.get(0).movingForward();
        racingCarList.get(1).stop();
        racingCarList.get(2).stop();

        assertThat(new RacingWinners(racingCars.getWinners()).toString()).isEqualTo("최종 우승자는 pobi 입니다.");
    }
}