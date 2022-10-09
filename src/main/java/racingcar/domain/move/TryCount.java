package racingcar.domain.move;

public class TryCount {

    private int count;

    public TryCount(int count) {
        this.count = (count + 1);
    }

    public boolean letsTry() {
        this.count -= 1;
        return this.count > 0;
    }
}
