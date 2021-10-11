package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racinggame.utils.RacingGameUtils.ERROR_MESSAGE;
import static racinggame.utils.RacingGameUtils.getRacingCarList;

class RacingCarsTest {
    @ParameterizedTest(name = "자동차 일급콜렉션 객체를 생성한다")
    @ValueSource(strings = {"pobi,crong,honux"})
    void 자동차_일급콜렉션_객체를_생성한다(String racingCarNameInput) {
        RacingCars racingCars = new RacingCars(getRacingCarList(racingCarNameInput));

        assertThat(racingCars.getRacingCars()).isInstanceOf(List.class);
        assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "[{0}] 자동차 일급콜렉션 객체 유효성을 검증한다")
    @ValueSource(strings = {"javaji", ""})
    void 자동차_일급콜렉션_객체_유효성을_검증한다(String racingCarNameInput) {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> {
                    new RacingCars(getRacingCarList(racingCarNameInput));
                }).withMessage(ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "가장 큰 전진 횟수를 반환한다")
    @ValueSource(strings = {"pobi,crong,honux"})
    void 가장_큰_전진_횟수를_반환한다(String racingCarNameInput) {
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

        assertThat(racingCars.getMaxMovesCount()).isEqualTo(2);
    }

    @ParameterizedTest(name = "우승자를 선별하여 반환한다(공동 우승 가능)")
    @ValueSource(strings = {"pobi,crong,honux"})
    void 우승자를_선별하여_반환한다(String racingCarNameInput) {
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
        /* 3회 */
        racingCarList.get(0).stop();
        racingCarList.get(1).move();
        racingCarList.get(2).move();

        List<RacingCar> winners = racingCars.getWinners();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getRacingCarName()).isEqualTo("pobi");
        assertThat(winners.get(1).getRacingCarName()).isEqualTo("crong");
    }

    @ParameterizedTest(name = "우승자 자동차 이름을 출력한다(공동 우승)")
    @ValueSource(strings = {"pobi,crong,honux"})
    void 우승자_자동차_이름을_출력한다_공동_우승(String racingCarNameInput) {
        RacingCars racingCars = new RacingCars(getRacingCarList(racingCarNameInput));
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        /* 1회 */
        racingCarList.get(0).move();
        racingCarList.get(1).move();
        racingCarList.get(2).stop();
        /* 2회 */
        racingCarList.get(0).move();
        racingCarList.get(1).move();
        racingCarList.get(2).stop();

        assertThat(racingCars.toString()).isEqualTo("최종 우승자는 pobi,crong 입니다.");
    }

    @ParameterizedTest(name = "우승자 자동차 이름을 출력한다")
    @ValueSource(strings = {"pobi,crong,honux"})
    void 우승자_자동차_이름을_출력한다(String racingCarNameInput) {
        RacingCars racingCars = new RacingCars(getRacingCarList(racingCarNameInput));
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        /* 1회 */
        racingCarList.get(0).move();
        racingCarList.get(1).move();
        racingCarList.get(2).stop();
        /* 2회 */
        racingCarList.get(0).move();
        racingCarList.get(1).stop();
        racingCarList.get(2).stop();

        assertThat(racingCars.toString()).isEqualTo("최종 우승자는 pobi 입니다.");
    }
}