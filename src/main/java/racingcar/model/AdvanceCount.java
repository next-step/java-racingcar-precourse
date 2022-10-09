package racingcar.model;

public class AdvanceCount {

    private int count = 0;

    public void addedCount() {
        this.count += 1;
    }

    public int getNowCount() {
        return count;
    }

    public String getRacingRoad() {
        StringBuilder road = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            road.append("-");
        }
        return road.toString();
    }
}
