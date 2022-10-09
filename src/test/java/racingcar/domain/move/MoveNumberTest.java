package racingcar.domain.move;

import org.junit.jupiter.api.Test;
import racingcar.domain.move.MoveNumber;
import racingcar.domain.move.MoveType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveNumberTest {

    @Test
    void 주어진_값이_4이상이면_전진한다() {
        MoveNumber moveNumber = MoveNumber.valueOf(4);

        MoveType moveType = moveNumber.get();

        assertThat(moveType).isSameAs(MoveType.GO);
        assertThat(moveType).isNotSameAs(MoveType.STOP);
    }

    @Test
    void 주어진_값이_3이하이면_멈춘다() {
        MoveNumber moveNumber = MoveNumber.valueOf(3);

        MoveType moveType = moveNumber.get();

        assertThat(moveType).isSameAs(MoveType.STOP);
        assertThat(moveType).isNotSameAs(MoveType.GO);
    }

    @Test
    void 주어진_값이_1에서_9까지가_아니라면_에러발생() {
        assertDoesNotThrow(() -> {
            MoveNumber.valueOf(9);
            MoveNumber.valueOf(1);
        });

        IllegalArgumentException exception10 = assertThrows(IllegalArgumentException.class, () -> {
            MoveNumber.valueOf(10);
        });

        IllegalArgumentException exception0 = assertThrows(IllegalArgumentException.class, () -> {
            MoveNumber.valueOf(0);
        });

        assertThat(exception10.getMessage()).isEqualTo("[ERROR] 숫자는 1에서 9까지만 입력 가능합니다.");
        assertThat(exception0.getMessage()).isEqualTo("[ERROR] 숫자는 1에서 9까지만 입력 가능합니다.");
    }
}
