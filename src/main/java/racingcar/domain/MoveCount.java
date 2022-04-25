package racingcar.domain;

import racingcar.view.ErrorMessage;

public class MoveCount {
    private final int count;

    public MoveCount(String moveCountStr) {
        try {
            this.count = Integer.parseInt(moveCountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_MOVECOUNT.getMessage());
        }
    }

    public int getCount() {
        return count;
    }
}
