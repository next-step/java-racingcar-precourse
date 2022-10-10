package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class RacingGame {

    private final RacingCars racingCars;
    private final MovingStrategy movingStrategy;
    private final int maxRaceNumber;
    private final Result result;
    private int currentRacingNumber;

    private RacingGame(RacingCars racingCars, MovingStrategy movingStrategy, int maxRaceNumber) {
        this.racingCars = racingCars;
        this.movingStrategy = movingStrategy;
        this.maxRaceNumber = maxRaceNumber;
        this.result = Result.createInitialResult();
    }

    public static RacingGame of(RacingCars racingCars, MovingStrategy movingStrategy, int maxRaceNumber) {
        return new RacingGame(racingCars, movingStrategy, maxRaceNumber);
    }

    private void race() {
        racingCars.move(movingStrategy);
        Records records = racingCars.getRecords();
        result.add(records);
        currentRacingNumber++;
    }

    public void play() {
        while (!isGameOver()) {
            race();
        }
    }

    public Result getResult() {
        return this.result;
    }

    protected boolean isGameOver() {
        return currentRacingNumber >= maxRaceNumber;
    }

}
