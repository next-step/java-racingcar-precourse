package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.enums.MoveStatus;
import racingcar.model.Move;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class MoveTest {

    private static final String JIN_WON = "jinwon";

    @Test
    void 사용자는_몇_번_이동할_것인지_입력한다() {
        final Move move = new Move("3");
        int moves = move.remainMoves();
        assertThat(moves).isEqualTo(3);

        final ThrowingCallable overAllowedNumberCase = () -> new Move("31231232132132131");
        assertThatThrownBy(overAllowedNumberCase).isInstanceOf(IllegalArgumentException.class);

        final ThrowingCallable lessAllowedNumberCase = () -> new Move("-1");
        assertThatThrownBy(lessAllowedNumberCase).isInstanceOf(IllegalArgumentException.class);

        final ThrowingCallable notNumberCase = () -> new Move("이건몰랐징?");
        assertThatThrownBy(notNumberCase).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_값을_통해_이동한다() {
        final HashMap<String, Integer> map = new HashMap<>();
        map.put(JIN_WON, 3);

        final Move move = new Move("3");
        final Map<String, MoveStatus> stayCaseMap = move.moveStatus(map);
        assertThat(stayCaseMap).containsValue(MoveStatus.STAY);

        map.put(JIN_WON, 4);
        final Map<String, MoveStatus> moveCaseMap = move.moveStatus(map);
        assertThat(moveCaseMap).containsValue(MoveStatus.MOVE);

        map.put(JIN_WON, 10);
        final ThrowingCallable notAllowedCase = () -> move.moveStatus(map);
        assertThatThrownBy(notAllowedCase).isInstanceOf(IllegalArgumentException.class);

        map.put(JIN_WON, 1);
        final Map<String, MoveStatus> leastMoveCaseMap = move.moveStatus(map);
        assertThat(leastMoveCaseMap).containsValue(MoveStatus.STAY);

        map.put(JIN_WON, 3);
        final ThrowingCallable overCountCase = () -> move.moveStatus(map);
        assertThatThrownBy(overCountCase).isInstanceOf(IllegalArgumentException.class);
    }
}
