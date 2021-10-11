package racinggame.domain;

public class RaceResult {
    private CarName name;
    private Distance distance;

    public RaceResult(RacingCar racingCar) {
        this.name = new CarName(racingCar.getName());
        this.distance = new Distance(racingCar.getDistance());
    }

    public CarName getName() {
        return name;
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public boolean isLeadRacer(int leadDistance) {
        return leadDistance == distance.getDistance();
    }
}
