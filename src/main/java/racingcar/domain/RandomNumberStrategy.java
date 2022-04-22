package racingcar.domain;

public class RandomNumberStrategy implements MovingStrategy {
    public static final int MIN_STANDARD_NUMBER = 4;
    private final RandomNumberGenerator generator;

    public RandomNumberStrategy(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public boolean isMove() {
        return generator.generate() >= MIN_STANDARD_NUMBER;
    }
}
