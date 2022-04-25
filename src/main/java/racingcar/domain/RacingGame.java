package racingcar.domain;

import java.util.List;

public class RacingGame {
    private RacingCars cars;
    private RepeatCount repeatCount;
    private int finishCount;
    private boolean gameEnd;

    public RacingGame(RacingCars cars, int repeatCount) {
        this.cars = cars;
        this.repeatCount = new RepeatCount(repeatCount);
        this.finishCount = 0;
        this.gameEnd = false;
    }

    public boolean isGameEnd() {
        return this.gameEnd;
    }

    public void playSingleRound() {
        cars.moveCars();
        updateSingleRound();
    }

    public List<String[]> getCurrentCarsStatus() {
        return cars.getCurrentStatus();
    }

    public List<String> getWinnerNames() {
        int winnerPosition = cars.getMaxPosition();
        return cars.getCarNamesByPosition(winnerPosition);
    }

    private void updateSingleRound() {
        finishCount ++;
        if (finishCount == repeatCount.getValue()) {
            gameEnd = true;
        }
    }
}
