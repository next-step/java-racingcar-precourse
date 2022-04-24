package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 포지션_초기화() {
        Assertions.assertThat(new Position().getValue()).isEqualTo(0);
    }

}