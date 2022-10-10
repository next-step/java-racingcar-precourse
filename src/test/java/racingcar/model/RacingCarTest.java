package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @DisplayName("자동차 random 값을 구한 후 random 값이 4 이상일 경우 전진 하는가")
    @Test
    public void validateCarRandomNumberFourMoveForward() {

        RacingCar racingCar = new RacingCar("car");

        racingCar.move(() -> true);

        assertThat(racingCar.getRacingCarPosition()).isEqualTo(new RacingCarPosition(1));
    }

    @DisplayName("자동차 정지 테스트")
    @Test
    public void validateCarStopTest() {

        RacingCar racingCar = new RacingCar("ray");

        racingCar.move(() -> false);

        assertThat(racingCar.getRacingCarPosition()).isEqualTo(new RacingCarPosition(0));
    }

    @DisplayName("null 또는 공백 문자열이 입력되면 예외를 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void throwExceptionWhenCarNameNull(String input) {

        assertThatThrownBy(() -> {
            new RacingCarName(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("자동차 이름 5글자 이상 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"sonata"})
    public void throwExceptionWhenCarNameLargeThanFive(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCarName(input);
        });
    }

    @DisplayName("자동차 이름 빈값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    public void throwExceptionWhenCarNameContainsBlank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCarName(input);
        });
    }

    @DisplayName("자동차 같은 위치 테스트")
    @Test
    public void racingCarIsSamePositionTest() {
        RacingCar racingCar = new RacingCar("ray");
        RacingCar racingCar1 = new RacingCar("benz");

        boolean samePositionRacingCar = racingCar.isSamePositionRacingCar(racingCar1.getRacingCarPosition());

        assertThat(samePositionRacingCar).isTrue();
    }

    @DisplayName("자동차 같은 위치 테스트2")
    @Test
    public void racingCarIsSamePositionTest2() {
        RacingCar racingCar = new RacingCar("ray");
        RacingCar racingCar1 = new RacingCar("benz");

        racingCar.move(() -> true);
        racingCar1.move(() -> true);

        boolean samePositionRacingCar = racingCar.isSamePositionRacingCar(racingCar1.getRacingCarPosition());

        assertThat(samePositionRacingCar).isTrue();
    }

    @DisplayName("자동차 다른 위치 테스트")
    @Test
    public void racingCarIsNotSamePositionTest() {
        RacingCar racingCar = new RacingCar("ray");
        RacingCar racingCar1 = new RacingCar("benz");

        racingCar.move(() -> true);
        racingCar1.move(() -> false);

        boolean samePositionRacingCar = racingCar.isSamePositionRacingCar(racingCar1.getRacingCarPosition());

        assertThat(samePositionRacingCar).isFalse();

    }


}
