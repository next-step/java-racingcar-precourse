package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RacingGameStep racingGameStep;

    private RacingGame(Cars cars, RacingGameStep racingGameStep) {
        this.cars = cars;
        this.racingGameStep = racingGameStep;
    }

    public static RacingGame of(Cars cars, RacingGameStep racingGameStep) {
        return new RacingGame(cars, racingGameStep);
    }

    public void play() {
        this.cars.run();
    }

    public Cars getCars() {
        return this.cars;
    }

    public boolean isEndGame(int playStep) {
        return this.racingGameStep.getValue() == playStep;
    }

    public List<Car> findMaxDistanceCars() {
        Distance maxDistance = this.cars.findMaxDistance();
        return this.cars.findByMatchDistance(maxDistance);
    }
}
