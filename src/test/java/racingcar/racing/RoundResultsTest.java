package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.TestCarsUtils.testGoRoundResult;
import static racingcar.utils.TestCarsUtils.testRandomRoundResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class RoundResultsTest {

    @Test
    @DisplayName("실행결과 기록 성공 테스트")
    void result() {
        // given
        final RoundResults roundResults = RoundResults.init();

        // when
        roundResults.result(testRandomRoundResult());

        // then
        assertThat(roundResults.getRoundResults().size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("실행결과 기록 중 전진 조회 테스트")
    void getGoCars() {
        // given
        final RoundResults roundResults = RoundResults.init();
        final RoundResult roundResult = testGoRoundResult();
        roundResults.result(roundResult);

        // when & then
        roundResults.getGoCars()
                .each(car -> assertThat(car).isEqualTo(roundResult.getCar()));

    }

    @Test
    @DisplayName("실행결과들에 실행결과 추가 성공 테스트")
    void addAll() {
        // given
        final RoundResults roundResults1 = RoundResults.init();
        roundResults1.result(testRandomRoundResult());
        final RoundResults roundResults2 = RoundResults.init();
        roundResults2.result(testRandomRoundResult());

        // when
        roundResults1.addAll(roundResults2);

        // then
        assertThat(roundResults1.getRoundResults().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("실행결과들 취합하여 갯수 체크 성공 테스트")
    void summaryGoCount() {
        // given
        final RoundResults roundResults = RoundResults.init();
        final RoundResult roundResult = testGoRoundResult();
        final Car car = roundResult.getCar();
        roundResults.result(roundResult);
        roundResults.result(roundResult);
        roundResults.result(roundResult);

        // when & then
        assertThat(roundResults.summaryGoCount(car)).isEqualTo(3);
    }
}