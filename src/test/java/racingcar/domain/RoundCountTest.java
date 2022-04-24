package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.common.GameConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundCountTest {
    @ParameterizedTest
    @DisplayName("라운드_회차_증가_체크")
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void 라운드_회차_증가_체크(int number) {
        RoundCount roundCount = new RoundCount(GameConfig.BASE_ROUND_COUNT);
        for (int count = 0; count < number; count++) {
            roundCount.addRoundCount();
        }
        assertThat(roundCount.getRoundCount() == number).isTrue();
    }

    @ParameterizedTest
    @DisplayName("라운드_회차_시도횟수와_같은지_체크")
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void 라운드_회차_시도횟수와_같은지_체크(int number) {
        RoundCount roundCount = new RoundCount(1);
        assertThat(roundCount.isEqualTryCount(new RoundCount(1))).isTrue();
        assertThat(roundCount.isEqualTryCount(new RoundCount(2))).isFalse();
    }
}
