package racingcar.model.rule;

public class PlayCountRule {
    private final int minNum;
    private final int maxNum;

    public PlayCountRule(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
    }

    public int getMinNum() {
        return minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PlayCountRule)) {
            return false;
        }
        PlayCountRule po = (PlayCountRule) other;
        return po.minNum == minNum && po.maxNum == maxNum;
    }
}
