package util;

import static org.junit.jupiter.api.Assertions.*;
import static util.GeneralExceptionMessage.INVALID_MIN_MAX;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0부터 9까지의 랜덤한 숫자를 생성할 수 있다.")
    void testGenerateRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int randomNumber = randomNumberGenerator.generate(0, 9);
        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @Test
    @DisplayName("최소값이 최대값보다 크면 IllegalArgumentException을 던진다.")
    void testGenerateRandomNumberWithInvalidMinMax() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            randomNumberGenerator.generate(1, 0);
        });

        assertEquals(INVALID_MIN_MAX.getMessage(), exception.getMessage());
    }
}
