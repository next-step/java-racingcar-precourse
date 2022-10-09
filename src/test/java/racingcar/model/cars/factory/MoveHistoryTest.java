package racingcar.model.cars.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.jupiter.api.Test;

public class MoveHistoryTest {
    @Test
    void 히스토리_초기화하면_작동_이벤트_목록_길이_0() {
        assertThat(new MoveHistory().get().size()).isEqualTo(0);
    }

    @Test
    void 히스토리_조회하면_작동_이벤트_목록_복사본_생성() {
        MoveEvent moveEvent = mock(MoveEvent.class);
        MoveHistory moveHistory = new MoveHistory();
        moveHistory.add(moveEvent);

        List<MoveEvent> get1 = moveHistory.get();
        List<MoveEvent> get2 = moveHistory.get();

        assertThat(System.identityHashCode(moveEvent))
                .isNotEqualTo(System.identityHashCode(get1.get(0)))
                .isNotEqualTo(System.identityHashCode(get2.get(0)));
    }
}
