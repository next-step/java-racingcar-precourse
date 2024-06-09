package domain;

public class RacingCar {
    private RacingCarName racingCarName;

    public RacingCar(final String name) {
        this.racingCarName = new RacingCarName(name);
    }

    public RacingCarName getRacingCarName() {
        return racingCarName;
    }
}
