package racingcar.game;

import java.util.function.Consumer;
import racingcar.car.Cars;
import racingcar.racing.CumulativeRound;
import racingcar.racing.CumulativeRounds;
import racingcar.racing.Rounds;
import racingcar.racing.Winner;
import racingcar.racing.Winners;

public class RacingGame {
    private Cars cars;
    private Rounds rounds;
    private Winners winners;
    private CumulativeRounds cumulativeRounds;

    private RacingGame(final Cars cars, final Rounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public static RacingGame initOf(final InputCarNames inputCarNames, final InputRoundCount roundCount) {
        final Cars generateCars = Cars.valueOf(inputCarNames);
        return new RacingGame(generateCars, Rounds.countOf(roundCount, generateCars));
    }

    public void gameStart() {
        winners = rounds.startAll();
        this.cumulativeRounds = new CumulativeRounds(this.rounds);
    }

    public Cars winnersToCars() {
        return Cars.of(winners.mapTo(Winner::getCar));
    }

    public boolean isFinish() {
        return rounds.isFinish();
    }

    public void cumulativeRoundsEach(final Consumer<CumulativeRound> consumer) {
        this.cumulativeRounds.each(consumer);
    }
}
