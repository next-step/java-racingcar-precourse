package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionTest {

    @Test
    @DisplayName("포지션 값 검증 진행")
    void getPosition() {
        Position position = new Position(3);
        assertThat(position.getPositionStr()).isEqualTo("---");
    }

}