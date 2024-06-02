package utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {
    
    @Test
    @DisplayName("무작위 숫자가 0 ~ 9 범위에 있는지 테스트")
    public void testGenerateRandomNumber() {
        int randomNumber = RandomGenerator.generateRandomNumber();
        assertTrue(randomNumber >= 0 && randomNumber < 10);
    }
}
