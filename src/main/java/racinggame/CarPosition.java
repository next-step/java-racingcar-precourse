package racinggame;

public class CarPosition {
    int position;

    public CarPosition() {
        this.position = 0;
    }

    public void next() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
