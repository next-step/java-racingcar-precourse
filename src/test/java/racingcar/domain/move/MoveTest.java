package racingcar.domain.move;

import org.junit.jupiter.api.Test;
import racingcar.domain.move.Move;
import racingcar.domain.move.MoveType;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveTest {

    @Test
    void 주어진_값이_4이상이면_전진한다() {
        Move move = new Move(() -> 4);

        MoveType moveType = move.goOrStop();

        assertThat(moveType).isSameAs(MoveType.GO);
        assertThat(moveType).isNotSameAs(MoveType.STOP);
    }

    @Test
    void 주어진_값이_3이하이면_멈춘다() {
        Move move = new Move(() -> 3);

        MoveType moveType = move.goOrStop();

        assertThat(moveType).isSameAs(MoveType.STOP);
        assertThat(moveType).isNotSameAs(MoveType.GO);
    }

    @Test
    void 주어진_값이_1에서_9까지가_아니라면_에러발생() {
        assertDoesNotThrow(() -> {
            Move move9 = new Move(() -> 9);
            Move move1 = new Move(() -> 1);
            move9.goOrStop();
            move1.goOrStop();
        });

        IllegalArgumentException exception10 = assertThrows(IllegalArgumentException.class, () -> {
            Move move10 = new Move(() -> 10);
            move10.goOrStop();
        });

        IllegalArgumentException exception0 = assertThrows(IllegalArgumentException.class, () -> {
            Move move0 = new Move(() -> 0);
            move0.goOrStop();
        });

        assertThat(exception10.getMessage()).isEqualTo("[ERROR] 숫자는 1에서 9까지만 입력 가능합니다.");
        assertThat(exception0.getMessage()).isEqualTo("[ERROR] 숫자는 1에서 9까지만 입력 가능합니다.");
    }
}
