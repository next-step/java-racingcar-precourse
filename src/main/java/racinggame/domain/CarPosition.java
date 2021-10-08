package racinggame.domain;

public class CarPosition {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }
}
