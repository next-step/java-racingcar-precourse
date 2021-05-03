package racing.model.strategy;

public class RandomMoving implements Moving {

    private static int maxRandomValue;
    private static int minMovingRange;

    public RandomMoving(final int maxRandomValue, final int minMovingRange) {
        this.maxRandomValue = maxRandomValue;
        this.minMovingRange = minMovingRange;
    }

    @Override
    public int range() {
        return (int) Math.round(Math.random() * maxRandomValue);
    }

    /**
     * 앞으로 이동가능한지 판단
     *
     * @param compareValue
     * @return
     */
    public boolean isForward(int compareValue) {
        return compareValue >= minMovingRange;
    }

}
