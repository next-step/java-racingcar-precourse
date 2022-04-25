package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarCollection;

import java.util.List;

public class RaceResult {

    private List<Car> players;
    private List<Car> winners;

    private RaceResult(List<Car> players, List<Car> winners) {
        this.players = players;
        this.winners = winners;
    }

    public List<Car> getPlayers() {
        return players;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public static RaceResult from(CarCollection carCollection) {
        return new RaceResult(carCollection.getCars(), carCollection.getWinners());
    }
}
