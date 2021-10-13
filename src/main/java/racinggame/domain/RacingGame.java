package racinggame.domain;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public GameResult run(LapCount lapCount) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < lapCount.getValue(); i++) {
            gameResult.add(cars.move());
        }
        return gameResult;
    }
}
