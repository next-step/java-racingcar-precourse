package racingcar.model;

import racingcar.exception.NotNumericException;

import static java.lang.Integer.parseInt;

public class GameCount {

    private int gameCount;

    public GameCount(String gameCount) {
        validateGameCount(gameCount);
        this.gameCount = Integer.parseInt(gameCount);
    }

    private void validateGameCount(String gameCount) {
        try {
            parseInt(gameCount);
        } catch (Exception e) {
            throw new NotNumericException();
        }
    }

    public void play() {
        gameCount--;
    }

    public boolean isEnd() {
        return gameCount < 1;
    }
}
