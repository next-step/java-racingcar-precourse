package racingcar.domain;

public class CarDistance {

    private final int START_NUMBER = 0;

    private int position;

    public CarDistance() {
        this.position = START_NUMBER;
    }

    public int getDistance() {
        return position;
    }

    public void goForward() {
        this.position++;
    }
}
