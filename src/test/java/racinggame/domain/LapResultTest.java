package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LapResultTest {

    @Test
    void 최고_기록을_반환한다() {
        // given
        LapResult lapResult = new LapResult();
        lapResult.add(new Record(new CarName("crong"), 1));
        lapResult.add(new Record(new CarName("pobi"), 5));
        lapResult.add(new Record(new CarName("gaeul"), 5));

        // when
        List<Record> bestRecords = lapResult.getBestRecords();

        // then
        assertThat(bestRecords).containsExactly(new Record(new CarName("pobi"), 5), new Record(new CarName("gaeul"), 5));
    }
}