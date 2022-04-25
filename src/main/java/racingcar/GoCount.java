package racingcar;

public class GoCount {

    private final int START_COUNT = 0;

    public int goCount;

    public GoCount() {
        goCount = START_COUNT;
    }

    public void go() {
        this.goCount += 1;
    }

    public int nowPosition() {
        return goCount;
    }
}
