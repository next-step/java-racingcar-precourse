package racingcar.domain.car;

public class CarPosition {
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

}
