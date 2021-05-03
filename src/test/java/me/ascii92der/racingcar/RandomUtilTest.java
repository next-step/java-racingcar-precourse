package me.ascii92der.racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RandomUtilTest {

    @Test
    void randomNumberTest() {
        assertThat(RandomUtil.generateRandomNumber()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
