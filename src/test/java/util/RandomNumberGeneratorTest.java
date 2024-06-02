package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("randomGenerator Instance 확인 테스트")
    void getInstance() {
        Random randomGenerator = RandomNumberGenerator.getInstance();
        Assertions.assertThat(randomGenerator).isSameAs(RandomNumberGenerator.getInstance());
    }

    @Test
    @DisplayName("무작위 숫자 값 범위 확인 테스트")
    void generateRandomNumber() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber();
        org.junit.jupiter.api.Assertions.assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }
}