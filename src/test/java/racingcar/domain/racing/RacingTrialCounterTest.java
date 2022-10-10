package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static racingcar.domain.Utils.repeat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTrialCounterTest {
    @ParameterizedTest(name = "최대 전진 시도 횟수는 양수여야 한다. 입력값: [{0}]")
    @ValueSource(ints = {0, -1})
    void shouldBePositive(int trialsLimit) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingTrialCounter(trialsLimit))
                .withMessageMatching("시도할 횟수는 1 이상이어야 합니다! 입력값: .+");
    }

    @ParameterizedTest(name = "최대 전진 시도 횟수만큼 시도 횟수를 증가시킬 수 있다.")
    @ValueSource(ints = {1, 3, 10})
    void incrementUntilLimit(int trialsLimit) {
        final RacingTrialCounter counter = new RacingTrialCounter(trialsLimit);

        assertThatNoException()
                .isThrownBy(() -> repeat(trialsLimit, counter::incrementTrialCount));
    }

    @ParameterizedTest(name = "최대 전진 시도를 초과하여 시도 횟수를 증가시킬 수 없다.")
    @ValueSource(ints = {1, 3, 10})
    void cannotIncrementBeyondTheLimit(int trialsLimit) {
        final RacingTrialCounter counter = new RacingTrialCounter(trialsLimit);
        repeat(trialsLimit, counter::incrementTrialCount);

        assertThatIllegalStateException()
                .isThrownBy(counter::incrementTrialCount)
                .withMessage("경주 시도 횟수를 초과하였습니다!");
    }

}
