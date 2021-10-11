package racinggame.domain;

import racinggame.type.MovingStatus;

public class RacingCar {
    private CarName name;
    private Distance distance;

    public RacingCar(CarName name) {
        this.name = name;
        this.distance = new Distance();
    }

    public void move(int moving) {
        if (MovingStatus.isForward(moving)) {
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
}
