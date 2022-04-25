package racingcar.controller.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.Laps;

public class LapsTest {

    private Laps laps;

    @Test
    @DisplayName("Laps에 0 이하 할당 시 예외 발생")
    void Laps_0_할당시_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> laps = new Laps("0"));
    }

    @Test
    @DisplayName("Laps에 숫자 아닌 문자열 할당 시 예외 발생")
    void Laps_숫자아닌_문자열_할당시_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> laps = new Laps("abc"));
    }

    @Test
    @DisplayName("Laps에 할당된 수 보다 countDown 메시지가 많이 발생 시 예외 발생")
    void Laps_2일때_세번_countDown시_예외발생() {
        String strLaps = "2";
        laps = new Laps(strLaps);

        assertThrows(IllegalStateException.class, () -> downCount(3));
    }

    @Test
    @DisplayName("Laps에 할당된 수 까지 countDown 가능")
    void Laps_2일때_두번_countDown_가능() {
        String strLaps = "2";
        laps = new Laps(strLaps);
        assertDoesNotThrow(() -> downCount(2));
        assertThat(laps.hasNext()).isFalse();
    }

    private void downCount(int count) {
        for (int i = 0; i < count; i++) {
            laps.lapCountDown();
        }
    }
}
