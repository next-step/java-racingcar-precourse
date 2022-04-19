package racingcar.model.car;

public class CarPosition {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    void increasePosition() {
        this.position++;
    }
}
