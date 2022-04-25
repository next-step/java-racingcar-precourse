package racingcar.domain;

public class Position {
    private int position = 0;

    public void go() {
        this.position += 1;
    }

    public int getPosition() {
        return position;
    }
}
