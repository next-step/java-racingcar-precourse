package racingcar.domain;

public class Car {
    public static final int DEFAULT_POSITION = 0;
    public static final int MOVE_DISTANCE = 1;

    private CarName name;
    private CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition(DEFAULT_POSITION);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(MovingStrategy strategy) {
        if (strategy.isMovable()) {
            position.addPosition(MOVE_DISTANCE);
        }
    }

    public boolean isWinner(int winnerPosition) {
        return this.position.getPosition() == winnerPosition;
    }
}
