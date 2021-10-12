package racinggame;

public class Position {
    private static final int START_POSITION = 0;
    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public int getValue() {
        return this.position;
    }
}
