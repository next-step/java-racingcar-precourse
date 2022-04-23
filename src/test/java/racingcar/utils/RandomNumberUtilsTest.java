package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberUtilsTest {

    @DisplayName("랜덤 넘버가 0~9 사이 인지 검증")
    @Test
    void getRandomNumberFromZeroToNine() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = RandomNumberUtils.getRandomNumberFromZeroToNine();
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }

}