package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.TestCarsUtils.testCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class RoundResultTest {

    @Test
    @DisplayName("경주 실행 결과 생성 성공 테스트")
    void report() {
        // given

        // when
        final RoundResult roundResult = RoundResult.report(testCar(), RacingCarResult.GO);

        // then
        assertThat(roundResult).isNotNull();
    }

    @Test
    @DisplayName("경주 실행 결과 생성 실패 테스트")
    void report_exception() {
        // given

        // when & then
        assertThatThrownBy(() -> RoundResult.report(null, null))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("경주 실행 결과 전진 확인 테스트")
    void isGo() {
        // given
        final RoundResult roundResult = RoundResult.report(testCar(), RacingCarResult.GO);

        // when & then
        assertThat(roundResult.isGo()).isTrue();

    }

    @Test
    @DisplayName("경주 실행 결과 해당 자동차인지 확인하는 테스트")
    void hasCar() {
        // given
        final Car car = testCar();
        final RoundResult roundResult = RoundResult.report(car, RacingCarResult.GO);

        // when & then
        assertThat(roundResult.hasCar(car)).isTrue();

    }

}