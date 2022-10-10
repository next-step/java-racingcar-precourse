package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.view.Input;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    void addWinner() {
        GameResult gameResult = new GameResult(new Spot(1), Input.parseCars("a,b"));
        gameResult.addWinner(new Car("c"));
        assertThat(gameResult.winners()).hasSize(3);
    }
}
