package racinggame.domain;

import racinggame.type.MovingStatus;

public class RaceRecord {
    private CarName carName;
    private Distance distance;
    private MovingStatus status;

    public RaceRecord(RacingCar racingCar) {
        this.carName = new CarName(racingCar.getName());
        this.distance = new Distance(racingCar.getDistance());
        this.status = racingCar.getMovingStatus();
    }

    public String reportMessage() {
        return carName.getName() + " : " + distance.report() + "\n";
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public MovingStatus getStatus() {
        return status;
    }
}
