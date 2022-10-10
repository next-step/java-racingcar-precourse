package racingcar.model;

public class Game {
    private final Cars cars;
    private final Progress progress;
    private GameStatus status;

    public Game(Cars cars, Progress progress) {
        this.cars = cars;
        this.progress = progress;
        status = GameStatus.PLAY;
    }

    public GameResults play() {
        GameResults gameResults = new GameResults();

        for (int i = 0; i < progressCount(); i++) {
            cars.move();
            gameResults.addGameResult(new GameResult(cars));
        }

        return gameResults;
    }

    public void end() {
        status = GameStatus.END;
    }

    public GameStatus getStatus() {
        return status;
    }

    public int carCount() {
        return cars.size();
    }

    public int progressCount() {
        return progress.getCount();
    }
}
