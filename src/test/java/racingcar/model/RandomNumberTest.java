package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {

    RandomNumber randomNumber;

    @BeforeEach
    void init() {
        randomNumber = new RandomNumber();
    }

    @Test
    void 랜덤_숫자_생성() {
        assertThat(randomNumber.next())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
