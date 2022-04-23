package racingcar.domain;

public class CarPosition {
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void increasePosition() {
        position += 1;
    }
}
