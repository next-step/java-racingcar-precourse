package racingcar.models;

import racingcar.validators.GameCountValidator;

public class GameCount {
    private final int count;

    public GameCount(String count) {
        this.validateCount(count);
        this.count = Integer.parseInt(count);
    }

    private void validateCount(String count) {
        new GameCountValidator(count).validate();
    }

    public int getCount() {
        return count;
    }
}
