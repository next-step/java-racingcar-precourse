package racingcar.domain;

public class AlwaysMovingStrategy implements MovingStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}
