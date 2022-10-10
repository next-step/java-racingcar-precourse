package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoveTest {
    @Test
    @DisplayName("count 1당 우측의 문자열로 치환 : -")
    void move_count_문자열_치환() {
        Move move = new Move(3);

        String s = move.replaceMoveCount();

        assertThat(s).isEqualTo("---");
    }

    @Test
    void move_count_문자열_치환_0개() {
        Move move = new Move(0);

        String s = move.replaceMoveCount();

        assertThat(s).isEqualTo("");
    }
}