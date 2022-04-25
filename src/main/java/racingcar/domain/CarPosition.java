package racingcar.domain;

public class CarPosition {
    private int position = 0;

    public void forwardPosition() {
        this.position += 1;
    }

    public int currentPosition() {
        return this.position;
    }
}
