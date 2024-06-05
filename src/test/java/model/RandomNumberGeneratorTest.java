package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorTest {

    @Test
    public void 여러번_테스트하여_랜덤_숫자가_0부터_9_사이에_있는지_확인() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int numberOfTests = 1000;

        // when & then
        for (int i = 0; i < numberOfTests; i++) {
            int randomNumber = generator.generateRandomNumber();
            assertTrue(randomNumber >= 0 && randomNumber < 10,
                    "Random number is out of range: " + randomNumber);
        }
    }
}
