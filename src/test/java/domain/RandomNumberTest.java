package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberTest {

    @Test
    @DisplayName("random Number가 0-9사이의 값이 나오는지 확인")
    void randomNumberRangeTest() {
        RandomNumber randomNumber = new RandomNumber();
        int max = 9;
        int min = 0;
        assertAll(
                () -> assertTrue(randomNumber.number() >= min),
                () -> assertTrue(randomNumber.number() <= max)
        );
    }

}
