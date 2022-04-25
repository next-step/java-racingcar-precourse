package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoveCountTest {
    @Test
    void 이동_횟수_입력() {
        MoveCount moveCount = new MoveCount("2");
        assertThat(moveCount.getCount()).isEqualTo(2);
    }
}