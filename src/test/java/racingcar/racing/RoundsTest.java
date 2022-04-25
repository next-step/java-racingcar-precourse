package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.utils.TestCarsUtils.testCars;
import static racingcar.utils.TestCarsUtils.testInputRoundCount;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.TestCarsUtils;

class RoundsTest {

    @Test
    @DisplayName("실행 결고 일급 콜렉션 실패 테스트")
    void countOf_exception() {
        // given

        // when & then
        assertThatThrownBy(() -> Rounds.countOf(null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라운드 전체 실행 테스트")
    void startAll() {
        // given
        final Rounds rounds = Rounds.countOf(testInputRoundCount(), testCars());

        // when
        rounds.startAll();

        // then
        assertThat(rounds.isFinish()).isTrue();
    }

    @Test
    @DisplayName("라운드 실행 누계 테스트")
    void cumulativeRoundResults() {
        // given
        final Rounds rounds = Rounds.countOf(testInputRoundCount(), testCars());
        rounds.startAll();

        // when
        final List<Round> roundList = rounds.getRounds();
        final Round round1 = roundList.get(0);
        final RoundResults roundResults1 = rounds.cumulativeRoundResults(round1);
        final Round round2 = roundList.get(roundList.size() - 1);
        final RoundResults roundResults2 = rounds.cumulativeRoundResults(round2);

        // then
        assertThat(roundResults2.getRoundResults().size()).isGreaterThanOrEqualTo(
                roundResults1.getRoundResults().size());
    }
}