package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomUtilsTest {
    @Test
    void 랜덤_숫자_체크() {
        assertThat(RandomUtils.getRandomNumber()).isBetween(1, 9);
        assertThat(RandomUtils.getRandomNumber()).isBetween(1, 9);
        assertThat(RandomUtils.getRandomNumber()).isBetween(1, 9);
    }
}