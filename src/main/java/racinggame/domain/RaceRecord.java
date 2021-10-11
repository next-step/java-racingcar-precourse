package racinggame.domain;

public class RaceRecord {
    private CarName carName;
    private Distance distance;

    public RaceRecord(RacingCar racingCar) {
        this.carName = new CarName(racingCar.getName());
        this.distance = new Distance(racingCar.getDistance());
    }

    public void report() {
        System.out.println(reportMessage());
    }

    public String reportMessage() {
        return carName.getName() + " : " + distance.report();
    }
}
