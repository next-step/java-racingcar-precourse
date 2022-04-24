package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.racing.car.Cars;
import racingcar.domain.racing.racer.Winner;

public class RacingResult {
    private final Winner winner;
    private final RacingHistory history;

    private RacingResult(Winner winner, List<Cars> history) {
        this.winner = winner;
        this.history = RacingHistory.from(history);
    }

    public static RacingResult of(Winner winner, List<Cars> history) {
        return new RacingResult(winner, history);
    }

    public Winner getWinner() {
        return winner;
    }

    public RacingHistory getHistory() {
        return history;
    }
}
