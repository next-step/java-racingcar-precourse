package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveStatusTest {

    @Test
    @DisplayName("0~9 사이 숫자 중 4이상일 경우 전진, 아닐 경우 정지")
    void getStatus() {
        assertThat(MoveStatus.getStatus(new RandomNumber(9))).isEqualTo(MoveStatus.MOVE);
        assertThat(MoveStatus.getStatus(new RandomNumber(4))).isEqualTo(MoveStatus.MOVE);
        assertThat(MoveStatus.getStatus(new RandomNumber(3))).isEqualTo(MoveStatus.STOP);
        assertThat(MoveStatus.getStatus(new RandomNumber(0))).isEqualTo(MoveStatus.STOP);
    }

}