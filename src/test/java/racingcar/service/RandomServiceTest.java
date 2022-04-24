package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomServiceTest {

    @DisplayName("랜덤한 1~9 사이의 숫자")
    @Test
    void getRandomNumber() {
        RandomService randomService = new RandomService();
        int number = randomService.getRandomNumber();

        assertTrue(number > 0);
        assertTrue(number < 10);
    }
}