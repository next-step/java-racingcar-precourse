package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new RacingCars(getRacingCarList(racingCarNameInput));
                }).withMessage(ERROR_MESSAGE);
    }
}