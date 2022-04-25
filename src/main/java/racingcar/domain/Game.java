package racingcar.domain;

public class Game {
    private final Cars cars;
    private final Round round;

    public Game(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public Cars getCars() {
        return cars;
    }

    public Round getRound() {
        return round;
    }

}
