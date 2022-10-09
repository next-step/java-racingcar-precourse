package racingcar.domain;

public class LabCount {

    private final int count;

    public LabCount(String count) {
        this.count = Integer.parseInt(count);
    }

    public int getCount() {
        return count;
    }
}
