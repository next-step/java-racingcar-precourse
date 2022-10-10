package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {

    @Test
    void randomGeneratorTest() {
        RandomGenerator randomGenerator = new RandomGenerator();
        Integer generatedNumber = randomGenerator.getGeneratedNumber();
        Assertions.assertTrue(generatedNumber >= Constants.RANDOM_MIN_NUMBER && generatedNumber <= Constants.RANDOM_MAX_NUMBER);

        RandomGenerator fixedNumberGenerator = new RandomGenerator(0);
        Assertions.assertEquals(0, fixedNumberGenerator.getGeneratedNumber());
    }
}
