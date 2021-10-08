package racinggame.model;

import racinggame.model.enums.Error;

public class TryCount {
    private static final int ZERO = 0;

    private int count;

    public TryCount(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if (count <= ZERO) {
            throw new IllegalArgumentException(Error.INVALID_COUNT.message());
        }
    }

    public boolean canPlaying() {
        return count > ZERO;
    }

    public void decrease() {
        count--;
    }
}
