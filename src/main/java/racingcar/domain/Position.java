package racingcar.domain;

public class Position {
    private static final String MOVE_FORWARD = "-";
    private int position;

    public Position() {
        position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String printPosition() {
        String positionVisualize = new String();
        for (int i = 0; i < position; i++) {
            positionVisualize += MOVE_FORWARD;
        }
        return positionVisualize;
    }
}
