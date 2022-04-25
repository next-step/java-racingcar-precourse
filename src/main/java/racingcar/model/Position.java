package racingcar.model;

public class Position {

    private int position;
    private static final int INIT_POSITION = 0;

    public Position() {
        this.position = INIT_POSITION;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
