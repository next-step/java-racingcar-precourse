package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultsTest {
    @Test
    @DisplayName("공동 우승일 경우 공동 우승자 이름 모두 리턴한다.")
    void contain_all_cowinners() {
        RaceResult raceResult = new RaceResult("aaa", 1);
        RaceResult raceResult1 = new RaceResult("bbb", 2);
        RaceResult raceResult2 = new RaceResult("ccc", 2);
        RaceResults raceResults = new RaceResults(Arrays.asList(raceResult1, raceResult, raceResult2));
        List<String> winners = raceResults.getWinners();
        assertThat(winners).contains("bbb","ccc");
    }

    @Test
    @DisplayName("공동 우승이 아닐 경우 우승자 이름 하나 리턴한다.")
    void contain_a_winner() {
        RaceResult raceResult = new RaceResult("aaa", 1);
        RaceResult raceResult1 = new RaceResult("bbb", 2);
        RaceResult raceResult2 = new RaceResult("ccc", 3);
        RaceResults raceResults = new RaceResults(Arrays.asList(raceResult1, raceResult, raceResult2));
        List<String> winners = raceResults.getWinners();
        assertThat(winners).containsOnly("ccc");
    }
}
