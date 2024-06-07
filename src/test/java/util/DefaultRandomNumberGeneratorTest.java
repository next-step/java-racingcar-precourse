package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultRandomNumberGeneratorTest {
    @Test
    @DisplayName("generateRandomNumber test")
    void generateRandomNumberTest() throws Exception {
        // when
        DefaultRandomNumberGenerator random = new DefaultRandomNumberGenerator();
        int result = random.generate();

        // then
        assertThat(result).isBetween(0, 9);
    }
}