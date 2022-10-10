package racingcar.model;

import java.util.Objects;

import static racingcar.ErrorMessages.NOT_TRY_NUMBER;
import static racingcar.ErrorMessages.TRY_CNT_NOT_NATURAL_NUMBER;

public class TryCount {
    private final int tryCount;

    public TryCount(String countString) {
        this.tryCount = convertStringToInt(countString);
        validatePositive(tryCount);
    }

    public boolean isNotSame(int tryCount) {
        return this.tryCount != tryCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TryCount tryCount1 = (TryCount)obj;
        return tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }

    private int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_TRY_NUMBER);
        }
    }

    private void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(TRY_CNT_NOT_NATURAL_NUMBER);
        }
    }
}
