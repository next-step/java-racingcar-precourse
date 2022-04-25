package racingcar.domain;

public class CarPosition {
    private int carPosition;

    public CarPosition(int carPosition) {
        this.carPosition = carPosition;
    }

    public void increase() {
        carPosition++;
    }

    @Override
    public String toString() {
        return Integer.toString(carPosition);
    }

    public int getCarPosition() {
        return carPosition;
    }
}
