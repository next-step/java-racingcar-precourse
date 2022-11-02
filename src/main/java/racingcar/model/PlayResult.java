package racingcar.model;

import racingcar.util.Message;

public class PlayResult {
    private String roundResult;
    private String gameResult;

    public void roundResult(Cars cars) {
        this.roundResult = cars.roundResult();
    }

    public void gameResult(Winners winners) {
        this.gameResult = Message.VICTORY_PREFIX.getMessage() + winners.getWinners();
    }

    public String getRoundResult() {
        return roundResult;
    }

    public String getGameResult() {
        return gameResult;
    }
}
