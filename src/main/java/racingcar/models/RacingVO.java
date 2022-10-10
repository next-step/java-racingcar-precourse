package racingcar.models;

public class RacingVO {
    private final Car[] cars;
    private final GameCount gameCount;

    public RacingVO(Car[] cars, GameCount gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public Car[] getCars() {
        return cars;
    }

    public GameCount getGameCount() {
        return gameCount;
    }
}
