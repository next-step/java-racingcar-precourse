package racingcar.model.laps;

public class LapsAnalyzer {
    private final int minValue;
    private final int maxValue;

    private LapsAnalyzer(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static LapsAnalyzer getInstance() {
        return new LapsAnalyzer(1, Integer.MAX_VALUE);
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
