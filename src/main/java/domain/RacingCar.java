package domain;

public class RacingCar {
    private RacingCarName racingCarName;
    private Distance distance;

    public RacingCar(final String name, final int distance) {
        this.racingCarName = new RacingCarName(name);
        this.distance = new Distance(distance);
    }

    public RacingCarName getRacingCarName() {
        return racingCarName;
    }
}
