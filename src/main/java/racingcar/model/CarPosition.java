package racingcar.model;

public class CarPosition {

    private int position = 0;

    public void movePosition(int move) {
        this.position += move;
    }

    public int getPosition() {
        return this.position;
    }

}
