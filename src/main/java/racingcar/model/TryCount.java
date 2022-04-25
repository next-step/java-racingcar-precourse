package racingcar.model;

import racingcar.model.exception.OverTryCountException;

import java.util.Objects;

public class TryCount {


    private static final String NUMBER_FORMAT_ERROR_MESSAEG = "숫자만 입력해 주세요.";
    private final int baseTryCount;
    private int tryCount;

    public TryCount(String baseTryCount) {
        this(baseTryCount, "0");
    }

    public TryCount(String baseTryCount, String tryCount) {
        this.baseTryCount = parseInt(baseTryCount);
        this.tryCount = parseInt(tryCount);
        validate();
    }

    private int parseInt(String baseTryCount) {
        try {
            return Integer.parseInt(baseTryCount);
        } catch (NumberFormatException e){
            throw new NumberFormatException(NUMBER_FORMAT_ERROR_MESSAEG);
        }
    }

    private void validate() {
        if (this.baseTryCount < this.tryCount) {
            throw new OverTryCountException();
        }
    }

    public void increaseCount() {
        if(isDone()) {
            throw new OverTryCountException();
        }
        tryCount++;
    }

    public boolean isDone() {
        return this.baseTryCount == this.tryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryCount tryCount1 = (TryCount) o;
        return baseTryCount == tryCount1.baseTryCount && tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseTryCount, tryCount);
    }

    @Override
    public String toString() {
        return "TryCount{" +
                "baseTryCount=" + baseTryCount +
                ", tryCount=" + tryCount +
                '}';
    }
}
