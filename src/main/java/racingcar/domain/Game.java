package racingcar.domain;

import java.util.List;

public class Game {

    private final Cars cars;
    private final RoundCount roundCount;

    public Game(Cars cars, RoundCount roundCount) {
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public boolean isOver() {
        return !roundCount.hasNextRound();
    }

    public List<String> round() {        
        roundCount.nextRound();

        cars.moveAllByRandom();
        return cars.getStatusList();
    }

    public Winners getWinners() {
        return cars.pickWinners();
    }
}
