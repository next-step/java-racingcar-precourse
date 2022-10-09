package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RecordDto;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("경주 관련 기능")
class RacingTest {
    @DisplayName("경주를 하고 기록을 확인한다.")
    @Test
    void create() {
        // given
        Entry entry = Entry.from("pobi,crong,honux");
        Lap lap = Lap.from("5");
        Racing racing = Racing.of(entry, lap);
        Movement movement = new LinkedList<>(
                Arrays.asList(true, false, true, true, true, true, true, true, true, true, true, true, true, true,
                              true))::poll;

        // when
        RecordDto recordDto = racing.race(movement);

        // then
        assertThat(recordDto.getLapPositions()).containsExactly(Arrays.asList("pobi : -", "crong : ", "honux : -"),
                                                                Arrays.asList("pobi : --", "crong : -", "honux : --"),
                                                                Arrays.asList("pobi : ---", "crong : --", "honux : ---"),
                                                                Arrays.asList("pobi : ----", "crong : ---", "honux : ----"),
                                                                Arrays.asList("pobi : -----", "crong : ----", "honux : -----"));
        assertThat(recordDto.getWinners()).containsExactly("pobi", "honux");
    }
}
