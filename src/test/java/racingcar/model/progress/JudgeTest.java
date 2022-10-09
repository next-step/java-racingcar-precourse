package racingcar.model.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import racingcar.model.cars.factory.MoveEvent;

public class JudgeTest {
    @Test
    void 유효_점수_기준_설정() {
        MinGoScoreInclusive minGoScoreInclusive = new MinGoScoreInclusive(4);
        assertThat(new Judge(minGoScoreInclusive).getMinGoScoreInclusive().get()).isEqualTo(minGoScoreInclusive.get());
    }

    @Test
    void 판정_유효() {
        MinGoScoreInclusive minGoScoreInclusive = new MinGoScoreInclusive(4);
        MoveEvent moveEvent = mock(MoveEvent.class);
        when(moveEvent.get()).thenReturn(minGoScoreInclusive.get());

        MoveScore moveScore = new Judge(minGoScoreInclusive).call(moveEvent);

        assertThat(moveScore).isEqualTo(Judge.GO_SCORE);
    }

    @Test
    void 판정_무효() {
        MinGoScoreInclusive minGoScoreInclusive = new MinGoScoreInclusive(4);
        MoveEvent moveEvent = mock(MoveEvent.class);
        when(moveEvent.get()).thenReturn(3);

        MoveScore moveScore = new Judge(minGoScoreInclusive).call(moveEvent);

        assertThat(moveScore).isEqualTo(Judge.STOP_SCORE);
    }
}
