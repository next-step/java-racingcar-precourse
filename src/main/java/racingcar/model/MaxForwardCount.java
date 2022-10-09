package racingcar.model;

public class MaxForwardCount {
    private long maxCount;

    public MaxForwardCount() {
        maxCount = Long.MIN_VALUE;
    }

    public void setMaxCount(long forwardCount) {
        maxCount = Math.max(maxCount, forwardCount);
    }

    public long getMaxCount() {
        return maxCount;
    }
}
