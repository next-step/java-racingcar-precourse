package racingcar.model.vo;

public class CarState {

    private final String carName;
    private int round;
    private int position;

    public CarState(Car car) {
        this.carName = car.getCarName();
    }

    public void addRound() {
        this.round++;
    }

    public void updatePosition(int add) {
        this.position += add;
    }

    public boolean checkPositionAhead(int position) {
        return this.position > position;
    }

    public boolean checkPositionSame(int position) {
        return this.position == position;
    }

    public String getCarName() {
        return carName;
    }

    public int getRound() {
        return round;
    }

    public int getPosition() {
        return position;
    }
}
