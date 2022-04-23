package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    @DisplayName("랜덤값을 추출하면 0~9 사이의 값이어야 한다")
    @Test
    void random_test() {
        RandomNumber randomNumber = new RandomNumber();

        assertThat(randomNumber.getRandomNumber())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
