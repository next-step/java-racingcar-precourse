package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameRoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 게임라운드_생성성공(String repeatNumber) {
        GameRound gameRound = new GameRound(repeatNumber);

        assertThat(gameRound.getValue()).isEqualTo(Integer.parseInt(repeatNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0t", "-1e"})
    void 숫자가_아닌_입력으로_게임라운드_생성실패(String repeatNumber) {
        assertThatThrownBy(() -> new GameRound(repeatNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 숫자여야 한다.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 숫자1_보다_작은_횟수입력으로_게임라운드_생성실패(String repeatNumber) {
        assertThatThrownBy(() -> new GameRound(repeatNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 게임 라운드는 1보다 작을 수 없습니다.");
    }
}
