package racingcar;

public class RandomMovableStrategy implements MovableStrategy {
    private static final int MIN_FORWARD_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return NumberGenerator.generate() >= MIN_FORWARD_CONDITION;
    }
}
