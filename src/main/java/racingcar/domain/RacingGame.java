package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private Round round;

    public RacingGame(String carNames, Round round) {
        this(CarsFactory.of(carNames), round);
    }

    public RacingGame(List<Car> cars, Round round) {
        this.cars = new Cars(cars);
        this.round = round;
    }

    public void race() {
        cars.move();
        round.finishPerRound();
    }

    public boolean isRacing() {
        return !round.isFinished();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

}
