package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {
    private  RandomNumber randomNumber;

    @BeforeEach
    void 테스트_준비() {
        randomNumber = new RandomNumber();
    }

    @Test
    void 랜덤숫자_범위_체크() {
        assertThat(randomNumber.generator()).isBetween(0, 9);
    }

}