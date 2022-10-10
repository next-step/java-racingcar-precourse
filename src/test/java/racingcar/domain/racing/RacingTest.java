package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racingcar.domain.Fixtures.createCarStatus;
import static racingcar.domain.Utils.repeat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Fixtures;

class RacingTest {

    @ParameterizedTest(name = "경주 자동차 목록은 null이 아니어야 한다.")
    @NullSource
    void carNamesShouldNotBeNull(RacingCars racingCars) {
        final int movingTrials = 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Racing(racingCars, movingTrials))
                .withMessage("The racing cars should not be null!");
    }

    @ParameterizedTest(name = "전진 시도 횟수는 양수여야 한다. 시도 횟수: {0}")
    @ValueSource(ints = {0, -1})
    void movingTrialsShouldBePositive(int movingTrials) {
        final List<String> carNames = Arrays.asList("pobi", "crong");
        final RacingCars cars = RacingCars.createdBy(carNames, Fixtures.ALWAYS_FORWARD_ONE_STRATEGY);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Racing(cars, movingTrials));
    }

    @DisplayName("생성 시 주어진 경주 시도 횟수를 초과하여 경기를 진행할 수 없다.")
    @Test
    void raceCountShouldNotExceedMovingTrialCount() {
        final Racing racing = Fixtures.createRacing(1, "pobi", "crong");

        racing.raceOnce();

        assertThatIllegalStateException()
                .isThrownBy(racing::raceOnce)
                .withMessage("경주 시도 횟수를 초과하였습니다!");

    }

    @DisplayName("경주를 진행하면 진행한 결과에 대한 자동차의 상태들이 반환된다.")
    @Test
    void race() {
        final Racing racing = Fixtures.createRacing(2, "pobi", "crong");
        final CarStatuses expectedOnce = Fixtures.carStatusesOf(1, "pobi", "crong");
        final CarStatuses expectedTwice = Fixtures.carStatusesOf(2, "pobi", "crong");

        final CarStatuses actualOnce = racing.raceOnce();
        final CarStatuses actualTwice = racing.raceOnce();

        assertAll(
                () -> assertThat(actualOnce).isEqualTo(expectedOnce),
                () -> assertThat(actualTwice).isEqualTo(expectedTwice)
        );
    }

    @ParameterizedTest(name = "경주 시도 횟수가 {0}이고 실제 {1}회 시도했을 때 경주가 종료되었는가: {2}")
    @CsvSource({
            "1, 0, false",
            "1, 1, true"
    })
    void isFinished(int trialLimit, int repeatCount, boolean expected) {
        final Racing racing = Fixtures.createRacing(trialLimit, "pobi", "crong");
        repeat(repeatCount, racing::raceOnce);

        final boolean actual = racing.isFinished();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("경주가 끝나기 전에는 최종 우승자를 알 수 없다.")
    @Test
    void shouldNotKnowWinnersBeforeFinished() {
        final Racing racing = Fixtures.createRacing(2, "pobi", "crong");

        assertThatIllegalStateException()
                .isThrownBy(racing::getWinners)
                .withMessage("The racing is not finished!");
    }

    @DisplayName("최종 우승자 목록을 알 수 있다.")
    @Test
    void winners() {
        final Racing racing = Fixtures.createRacing(1, "pobi", "crong");
        racing.raceOnce();
        final List<CarStatus> expected = Arrays.asList(
                createCarStatus("pobi", 1),
                createCarStatus("crong", 1)
        );

        final CarStatuses winners = racing.getWinners();

        assertThat(winners.toList()).containsExactlyInAnyOrderElementsOf(expected);
    }
}
