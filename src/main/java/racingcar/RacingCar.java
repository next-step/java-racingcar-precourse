package racingcar;

public class RacingCar {
    private final RacingCarName racingCarName;
    private final RacingCarLocation location = new RacingCarLocation();

    public RacingCar(String name) {
        this.racingCarName = new RacingCarName(name);
    }

    public void moveOnCondition(int number) {
        location.moveOnCondition(number);
    }

    public RacingCarName getRacingCarName() {
        return this.racingCarName;
    }

    public String getLocation() {
        return this.location.getLocation();
    }

    public int getCurrentLocation() {
        return this.location.getLocation().length();
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "racingCarName=" + racingCarName +
                ", location=" + location +
                '}';
    }
}
