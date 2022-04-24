package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
    }

    @Test
    void 정상_난수_정수_생성() {
        assertThat(randomNumber.getRandomNumber() > Integer.MIN_VALUE).isTrue();
        assertThat(randomNumber.getRandomNumber() < Integer.MAX_VALUE).isTrue();
    }

    @Test
    void 정상_난수_범위_생성() {
        assertTrue(randomNumber.isTrueOfMinimumValue());
        assertTrue(randomNumber.isTrueOfMaximumValue());
    }
}
