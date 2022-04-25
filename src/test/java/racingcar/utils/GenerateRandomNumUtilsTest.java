package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateRandomNumUtilsTest {

    @Test
    void 전진여부_판단을_위한_난수_정상생성여부_테스트() {
        int test_count = 100;
        GenerateRandomNumUtils generateRandomNumUtils = new GenerateRandomNumUtils();

        for (int i = 0; i < test_count; i++) {
            int num = generateRandomNumUtils.generateRandomNum();
            assertFalse(num < 0 || num > 9);
        }
    }
}