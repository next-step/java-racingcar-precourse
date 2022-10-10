package racingcar.model;

public class AlwaysWinStrategy implements RollStrategy {
    @Override
    public RollResult roll(Car car) {
        car.move();
        return new RollResult(true, car);
    }
}
