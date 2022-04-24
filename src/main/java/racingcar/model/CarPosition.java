package racingcar.model;

public class CarPosition {

    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void forward(int distance) {
        this.position += distance;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
