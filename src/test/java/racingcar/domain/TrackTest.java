package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrackTest {

    @Test
    void 숫자_트랙_예외_발생() {
        assertThatThrownBy(() -> new Track(-1))
                .hasMessage("레이싱 트랙 값이 유효하지 않습니다.");
    }
}
