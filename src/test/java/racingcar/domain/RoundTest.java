package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.common.GameConfig;
import racingcar.common.Message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {
    @ParameterizedTest
    @DisplayName("게임_종료_체크")
    @ValueSource(strings = { "1", "2", "3", "4", "5" })
    void 게임_종료_체크(String number) {
        Round round = new Round(GameConfig.BASE_ROUND_COUNT);
        RoundCount tryCount = new RoundCount(number);
        for (int count = 0; count < tryCount.getRoundCount(); count++) {
            round.playedRound();
        }
        assertThat(round.isGameEnd(tryCount)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("시도횟수_입력_자연수_체크")
    @ValueSource(strings = { "a", "0", "-1" })
    void 시도횟수_입력_자연수_체크(String tryCount) {
        assertThatThrownBy(() -> {
            new RoundCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_TRY_COUNT_NOT_NUMBER);
    }
}
