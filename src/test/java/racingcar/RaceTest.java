package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class RaceTest {
    @Test
    public void winnerTest() {
        ResultView resultView = new ResultView();

        Race race = new Race(new String[]{"pobi", "woni", "jun"}, 5, resultView);
        race.start();

        List<Car> winners = race.getWinners();
        assertThat(winners).isNotEmpty();
    }
}
