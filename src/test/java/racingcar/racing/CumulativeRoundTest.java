package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.TestCarsUtils.testGoRoundResult;
import static racingcar.utils.TestCarsUtils.testGoRoundResults;
import static racingcar.utils.TestCarsUtils.testRound;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class CumulativeRoundTest {

    @Test
    @DisplayName("자동차 별 전진 누계 테스트")
    void summaryGoCountByCar() {
        // given
        final Round round = testRound();
        final Car car = round.getCars().getCarByIndex(0);
        final CumulativeRound cumulativeRound = new CumulativeRound(round,
                testGoRoundResults(car));

        // when
        final int goCount = cumulativeRound.summaryGoCountByCar(car);

        // then
        assertThat(goCount).isEqualTo(1);
    }
}