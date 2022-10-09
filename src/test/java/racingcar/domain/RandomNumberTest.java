package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    @Test
    void 랜덤_숫자는_9보다_작거나_같음() {
        RandomNumber randomNumber = new RandomNumber();
        assertThat(randomNumber.getRandomNumber()).isLessThan(MAX_NUM + 1);
    }

    @Test
    void 랜덤_숫자는_0보다_크거나_같음() {
        RandomNumber randomNumber = new RandomNumber();
        assertThat(randomNumber.getRandomNumber()).isGreaterThan(MIN_NUM - 1);
    }
}
