package racingcar.domain;

public class CarPosition {
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public void addPosition(int addValue) {
        position += addValue;
    }

    public int getPosition() {
        return position;
    }
}
