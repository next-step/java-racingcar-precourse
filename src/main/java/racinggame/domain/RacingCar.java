package racinggame.domain;

import racinggame.type.MovingStatus;

public class RacingCar {
    private CarName name;
    private Distance distance;
    private MovingStatus movingStatus;

    public RacingCar(CarName name) {
        this.name = name;
        this.distance = new Distance();
        this.movingStatus = MovingStatus.STOP;
    }

    public void move(int moving) {
        movingStatus = MovingStatus.of(moving);
        if (MovingStatus.isForward(movingStatus)) {
            moveForward();
        }
    }

    public void moveForward() {
        distance.addDistance();
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public MovingStatus getMovingStatus() {
        return movingStatus;
    }
}
