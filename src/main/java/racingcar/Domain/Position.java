package racingcar.Domain;

public class Position {
    public static final int INIT_POSITION = 0;
    public static final int MOVE_POSITION = 1;
    private int position;

    public Position() {
        this.position = INIT_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPostion() {
        return this.position;
    }

    public void canMove() {
        this.position = this.position + MOVE_POSITION;
    }
}
