package racingcar.domain.car;

import static racingcar.utils.ValidationUtils.requireNotNull;

public class RandomMovingStrategy implements CarMovingStrategy {
    public static final int FORWARDING_THRESHOLD = 4;
    public static final int MINIMUM_NUMBER = 0;
    public static final int MAXIMUM_NUMBER = 9;
    private final RandomIntGenerator generator;

    public RandomMovingStrategy(RandomIntGenerator generator) {
        requireNotNull(generator, "The random int generator should not be null!");
        this.generator = generator;
    }

    @Override
    public Distance move() {
        final int randomNumber = generateNumber();

        if (randomNumber >= FORWARDING_THRESHOLD) {
            return new Distance(1);
        }
        return Distance.ZERO;
    }

    private int generateNumber() {
        final int randomNumber = generator.generate();
        if (randomNumber < MINIMUM_NUMBER || randomNumber > MAXIMUM_NUMBER) {
            throw new IllegalStateException("The value should be between 0 and 9!");
        }
        return randomNumber;
    }
}
