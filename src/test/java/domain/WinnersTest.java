package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    @DisplayName("최고점수 기반으로 우승자를 구해낸다")
    public void 최고점수_기반으로_우승자를_구해낸다() {

        CarHistories carHistories = new CarHistories(
                Arrays.asList(
                        new CarHistory(new CarName("A"), new Position(1)),
                        new CarHistory(new CarName("B"), new Position(2)),
                        new CarHistory(new CarName("C"), new Position(3)),
                        new CarHistory(new CarName("D"), new Position(2)),
                        new CarHistory(new CarName("E"), new Position(3))
                )
        );

        Winners winners = new Winners(carHistories);

        assertThat(winners.getWinners())
                .containsExactlyInAnyOrder(
                        new Winner(new CarName("C")),
                        new Winner(new CarName("E"))
                );
    }
}
