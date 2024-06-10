package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomsTest {

    @RepeatedTest(100)
    @DisplayName("랜덤값 생성 테스트")
    void generateRandomValueTest(){
        //given
        final int count = 3;
        final int start = 0;
        final int end = 9;

        //when
        var randomValues = Randoms.pickNumbersInRange(count, start, end);

        //then
        assertEquals(randomValues.size(), count);

        randomValues
                .forEach(randomValue -> {
                    assertTrue(randomValue <= 9 && randomValue >= 0);
                });
    }

    @Test
    @DisplayName("랜덤값 : start, end Excpetion Test")
    void wrongInputWithRangeTest() {
        //given
        final int count = 3;
        final int wrongStart = 10;
        final int wrongEnd = 1;
        //when


        //then
        assertThrows(IllegalArgumentException.class, () -> Randoms.pickNumbersInRange(count, wrongStart, wrongEnd));

    }
}