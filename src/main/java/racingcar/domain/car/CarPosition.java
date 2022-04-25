package racingcar.domain.car;

public class CarPosition {
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public static CarPosition of(int i) {
        return new CarPosition(i);
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
