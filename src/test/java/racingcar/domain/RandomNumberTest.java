package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    void 랜덤_0_9_사이_숫자_생성() {
        RandomNumber randomNumber = new RandomNumber();

        for (int i = 0; i < 100000; i++) {
            assertThat(randomNumber.getNumber()).isLessThan(10).isGreaterThan(-1);
        }
    }

}
