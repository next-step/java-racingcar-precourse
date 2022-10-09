package racingcar.model.laps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class LapsManagerTest {
    @Test
    void 초기화_현재_랩_0() {
        assertThat(new LapsManager(mock(Laps.class)).getCurrentLaps()).isEqualTo(0);
    }

    @Test
    void 다음_랩_이동() {
        Laps laps = mock(Laps.class);
        when(laps.get()).thenReturn(1000);
        LapsManager lapsManager = new LapsManager(laps);

        lapsManager.next();

        assertThat(lapsManager.getCurrentLaps()).isEqualTo(1);
    }

    @Test
    void 다음_랩_이동_예외() {
        Laps laps = mock(Laps.class);
        when(laps.get()).thenReturn(0);

        LapsManager lapsManager = new LapsManager(laps);

        assertThatThrownBy(() -> lapsManager.next()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 종료_여부_종료됨() {
        Laps laps = mock(Laps.class);
        when(laps.get()).thenReturn(0);

        assertThat(new LapsManager(laps).isFinished()).isTrue();
    }

    @Test
    void 종료_여부_종료안됨() {
        Laps laps = mock(Laps.class);
        when(laps.get()).thenReturn(10);

        LapsManager lapsManager = new LapsManager(laps);

        assertThat(lapsManager.isFinished()).isFalse();
    }
}
