package racingcar.models;

import java.util.HashMap;

public class GameResult {
    private final RacingScore dashboard = new RacingScore();

    public GameResult(Car[] cars) {
        for (Car car : cars) {
            this.dashboard.addScore(car, 0);
        }
    }

    public RacingScore getDashboard() {
        return dashboard;
    }

    public void addResult(Car car, boolean success) {
        this.dashboard.addScore(car, success ? 1 : 0);
    }

}
