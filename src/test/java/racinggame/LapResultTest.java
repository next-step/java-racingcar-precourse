package racinggame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LapResultTest {

    @Test
    void 최고_기록을_반환한다() {
        // given
        LapResult lapResult = new LapResult();
        lapResult.add(new Record("crong", 1));
        lapResult.add(new Record("pobi", 5));
        lapResult.add(new Record("gaeul", 5));

        // when
        List<Record> bestRecords = lapResult.getBestRecords();

        // then
        assertThat(bestRecords).containsExactly(new Record("pobi", 5), new Record("gaeul", 5));
    }
}