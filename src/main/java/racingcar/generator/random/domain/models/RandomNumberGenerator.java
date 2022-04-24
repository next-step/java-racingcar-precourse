package racingcar.generator.random.domain.models;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;
import racingcar.generator.random.domain.errors.NumberGeneratorErrors;

public class RandomNumberGenerator {

    private final int generated;

    public RandomNumberGenerator(int generated) {
        this.generated = generated;
    }

    public static RandomNumberGenerator generateNumberInRangeInclusively(int startInclusive, int endInclusive) {
        validate(startInclusive, endInclusive);

        return new RandomNumberGenerator(Randoms.pickNumberInRange(startInclusive, endInclusive));
    }

    private static void validate(int startInclusive, int endInclusive) {
        if (endInclusive < startInclusive) {
            throw new IllegalStateException(NumberGeneratorErrors.NUMBER_GENERATOR_START_GREATER_THAN_END_INCLUSIVE);
        }
    }

    public int getGenerated() {
        return generated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RandomNumberGenerator that = (RandomNumberGenerator) o;
        return generated == that.generated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(generated);
    }
}
