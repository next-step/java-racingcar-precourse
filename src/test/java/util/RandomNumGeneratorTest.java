package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumGeneratorTest {

    private final RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

    @Test
    @DisplayName("Generated random number is within range 0<=x<=9")
    void generatedRandomNumberIsWithinRange() {
        // When
        int randomNum = randomNumGenerator.getRandomInt();

        // Then
        assertThat(randomNum).isBetween(0, 9);
    }

}