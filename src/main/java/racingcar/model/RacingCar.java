package racingcar.model;

import racingcar.policy.MovingPolicy;

import java.util.Objects;

public class RacingCar {

    private static final int POSITION_INITIAL = 0;

    private final RacingCarName racingCarName;
    private final RacingCarPosition racingCarPosition;

    public RacingCar(String carName) {
        this.racingCarName = new RacingCarName(carName);
        this.racingCarPosition = new RacingCarPosition(POSITION_INITIAL);
    }

    public void move(MovingPolicy movingPolicy) {
        if (movingPolicy.isMovable()) {
            this.racingCarPosition.moveForward();
        }
    }

    public RacingCarName getRacingCarName() {
        return this.racingCarName;
    }

    public RacingCarPosition getRacingCarPosition() {
        return this.racingCarPosition;
    }

    public boolean isSamePositionRacingCar(RacingCarPosition racingCarPosition) {
        return this.racingCarPosition.equals(racingCarPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(racingCarName, racingCar.racingCarName) && Objects.equals(racingCarPosition, racingCar.racingCarPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarName, racingCarPosition);
    }
}
