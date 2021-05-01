package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    @DisplayName("최고점수 기반으로 우승자를 구해낸다")
    public void 최고점수_기반으로_우승자를_구해낸다() {

        Positions positions = new Positions(
                Arrays.asList(
                        new Position(new CarName("A"), 1),
                        new Position(new CarName("B"), 2),
                        new Position(new CarName("C"), 3),
                        new Position(new CarName("D"), 2),
                        new Position(new CarName("E"), 3)
                )
        );

        Winners winners = new Winners(positions);

        assertThat(winners.getWinners())
                .containsExactlyInAnyOrder(
                        new Winner(new CarName("C")),
                        new Winner(new CarName("E"))
                );
    }
}
