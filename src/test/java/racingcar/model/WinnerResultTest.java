package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerResultTest {
    @DisplayName("우승자 결과를 조회했을 때, 기대값과 일치해야 한다.")
    @Test
    public void getPrintWinnersSuccess_P01() {
        String expected = "hi, hello";
        ArrayList<CarName> winners = new ArrayList<>();
        winners.add(new CarName("hi"));
        winners.add(new CarName("hello"));
        WinnerResult winnerResult = new WinnerResult(winners);
        assertThat(winnerResult.getPrintWinners()).isEqualTo(expected);
    }
}
