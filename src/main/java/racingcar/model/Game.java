package racingcar.model;

public class Game {

    private final Cars cars;
    private final RaceCount raceCount;

    public Game(Names names, RaceCount raceCount) {
        this.cars = new Cars(names);
        this.raceCount = raceCount;
    }

    public int getRaceCount() {
        return this.raceCount.getValue();
    }

    public Cars race() {
        cars.moveAll();
        return cars;
    }

    public Names getWinners() {
        return cars.getMostMovedNames();
    }
}
