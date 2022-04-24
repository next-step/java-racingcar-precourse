package racingcar.model;

import racingcar.model.Message.ErrorMessage;
import racingcar.model.rule.PlayCountRule;

public class PlayCount {

    private final int playCount;
    private final PlayCountRule playCountRule;

    public PlayCount(String playCount, PlayCountRule playCountRule) {
        this.playCountRule = playCountRule;
        validPlayCount(playCount);
        this.playCount = Integer.parseInt(playCount);
    }

    public int getPlayCount() {
        return playCount;
    }

    private void validPlayCount(String playCount) {
        checkNumber(playCount);
        checkRangeNumber(playCount);
    }

    private void checkNumber(String playCount) {
        try {
            Integer.parseInt(playCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PLAY_COUNT);
        }
    }

    private void checkRangeNumber(String playCount) {
        int checkNumber = Integer.parseInt(playCount);
        if (checkNumber < playCountRule.getMinNum() || checkNumber > playCountRule.getMaxNum()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PLAY_COUNT);
        }
    }

}
