package nextstep.domain;

import nextstep.dto.MoveResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveResultTest {

    @Test
    void 거리_출력() {
        MoveResult result = new MoveResult("pobi", 3);
        assertThat(result.getDistance()).isEqualTo("---");
    }
}