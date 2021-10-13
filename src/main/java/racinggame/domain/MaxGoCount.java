package racinggame.domain;

public class MaxGoCount {
    private GoCount maxGoCount;

    public MaxGoCount() {
        maxGoCount = new GoCount();
    }

    public GoCount getMaxGoCount() {
        return maxGoCount;
    }

    public void setMaxGoCount(GoCount goCount) {
        maxGoCount.setGoCount(Math.max(maxGoCount.getGoCount(), goCount.getGoCount()));
    }
}
