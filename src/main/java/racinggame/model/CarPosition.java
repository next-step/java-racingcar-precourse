package racinggame.model;

public class CarPosition {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void forward() {
        this.position++;
    }
}
