package racingcar.model;

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
}
