package racingcar.domain;

public class Car {
    private CarName carName;

    private Position position;

    public Car(CarName carName) {
        this(carName, 0);
    }

    public Car(CarName carName, int position) {
        this.carName = carName;
        this.position = new Position(position);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position.move();
        }
    }

    public Position getCurrentPositon() {
        return position;
    }

    public String getMoveResult() {
        String currentPositionString = getCurrentPositionString();
        return this.carName.getCarName() + " : " + currentPositionString;
    }

    private String getCurrentPositionString() {
        return position.getCurrentPositionString();
    }

    public Car isWinner(Position maxPosition) {
        if(this.position.equals(maxPosition)) {
            return this;
        }
        return null;
    }

    public String getName() {
        return this.carName.getCarName();
    }
}
