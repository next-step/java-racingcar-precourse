package racingcar.domain.car.move;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DefaultMoveTest {

    Move move = new DefaultMove();

    @ParameterizedTest
    @DisplayName("전진->스탑->전진 테스트")
    @CsvSource(value = "9:3:4", delimiter = ':')
    void forward_stop(int move1, int stop, int move2) {
        assertThat(move.move(move1)).isEqualTo(Move.MOVE_FORWARD);
        assertThat(move.move(stop)).isEqualTo(Move.MOVE_FORWARD);
        assertThat(move.move(move2)).isEqualTo(Move.MOVE_FORWARD + Move.MOVE_FORWARD);
    }

    @Test
    @DisplayName("랜덤값이 3이하면 멈춤")
    void stop() {
        assertThat(move.move(3)).isEqualTo("");
    }

    @Test
    @DisplayName("랜덤값이 4이상이면 전진")
    void forward() {
        assertThat(move.move(4)).isEqualTo(Move.MOVE_FORWARD);
    }
}