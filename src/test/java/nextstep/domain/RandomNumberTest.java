package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {

    @Test
    void 랜덤_번호_생성() {
        RandomNumber randomNumber = new RandomNumber();
        int number = randomNumber.generate();
        assertThat(number).isGreaterThanOrEqualTo(0);
        assertThat(number).isLessThanOrEqualTo(9);
    }
}