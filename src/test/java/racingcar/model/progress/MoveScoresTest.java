package racingcar.model.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MoveScoresTest {
    @Test
    void 변환_작동_점수_목록() {
        MoveScore moveScore1 = mock(MoveScore.class);
        when(moveScore1.get()).thenReturn(1);

        MoveScore moveScore2 = mock(MoveScore.class);
        when(moveScore2.get()).thenReturn(2);
        List<MoveScore> moveScoresList = Arrays.asList(moveScore1, moveScore2);

        assertThat(MoveScores.of(moveScoresList).get()).isEqualTo(MoveScore.of(1 + 2));
    }
}
