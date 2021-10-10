package nextstep.domain;

import java.util.List;

public class Race {

    private final Cars cars;

    public Race(String names) {
        this.cars = new Cars(names, new RandomNumber());
    }

    public List<MoveResult> move() {
        return cars.move();
    }

    public RaceResult result() {
        return new RaceResult(cars.getWinners());
    }
}
