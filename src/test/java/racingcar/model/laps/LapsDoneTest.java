package racingcar.model.laps;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LapsDoneTest {
    @Test
    void 초기화_값_0() {
        assertThat(new LapsDone().get()).isEqualTo(0);
    }

    @Test
    void 진행_횟수_추가() {
        LapsDone lapsDone = new LapsDone();
        int expected = lapsDone.get() + 1;

        lapsDone.add();

        assertThat(lapsDone.get()).isEqualTo(expected);
    }
}
