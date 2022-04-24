package racingcar.model;


public class CarPosition {

    private final int START_POSITION = 0;

    private int position;

    public CarPosition() {
        this.position = START_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void goForward() {
        this.position++;
    }
}
