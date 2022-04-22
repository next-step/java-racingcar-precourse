package racingcar.model;

public class Count {

    private int count;

    public Count(int count) {
        this.count = count;
    }

    public void down() {
        count -= 1;
    }

    public boolean isRemain() {
        return count != 0;
    }
}
