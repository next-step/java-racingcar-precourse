package racingcar.model;

public class CarPosition {

    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void forward(int distance) {
        this.position += distance;
    }
}
