package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : choi-ys
 * @date : 2022/04/23 5:15 오후
 */
@DisplayName("Domain:RoundStatus")
class RoundStatusTest {

    @Test
    @DisplayName("전진/멈춤 상태 검증")
    public void roundStatusTest() {
        // Given
        RoundStatus go = RoundStatus.GO;
        RoundStatus stop = RoundStatus.STOP;

        // When & Then
        assertThat(go.isGo()).isTrue();
        assertThat(stop.isStop()).isTrue();
    }
}