package racingcar.model;

public class RollResult {
    public final boolean isMoved;
    public final Car car;

    public RollResult(boolean isMoved, Car car) {
        this.isMoved = isMoved;
        this.car = car;
    }
}
