package racingcar.domain;

import java.util.List;

public class Race {
    private final Players players;
    private GameCount gameCount;
    private final MovingStrategy movingStrategy;

    public Race(Players players, GameCount gameCount, MovingStrategy movingStrategy) {
        this.players = players;
        this.gameCount = gameCount;
        this.movingStrategy = movingStrategy;
    }

    public Race(List<Car> players, GameCount gameCount, MovingStrategy movingStrategy) {
        this.players = new Players(players);
        this.gameCount = gameCount;
        this.movingStrategy = movingStrategy;
    }

    public List<Car> run() {
        this.players.move(movingStrategy);
        this.gameCount = gameCount.downCount();
        return players.getPlayers();
    }

    public boolean onPlay() {
        return gameCount.isLeft();
    }

    public List<Car> getWinners() {
        return players.getWinners();
    }
}
