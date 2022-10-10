package racingcar.domain;

import java.util.Objects;

public class RacingCar {
    private final RacingCarName racingCarName;
    private final Location location;

    public RacingCar(RacingCarName racingCarName) {
        this.racingCarName = racingCarName;
        this.location = new Location();
    }

    public RacingCar(RacingCarName racingCarName, Location location) {
        this.racingCarName = racingCarName;
        this.location = location;
    }

    public static RacingCar copy(RacingCar origin) {
        return new RacingCar(
                new RacingCarName(origin.getRacingCarName().getRacingCarNameValue())
                , new Location(origin.getLocation().getLocationValue())
        );
    }

    public void race(MoveNumber moveNumber) {
        if (location.isMovable(moveNumber.getMoveNumber())) {
            location.move();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(racingCarName, racingCar.racingCarName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarName, location);
    }

    public Location getLocation() {
        return this.location;
    }

    public RacingCarName getRacingCarName() {
        return this.racingCarName;
    }
}
