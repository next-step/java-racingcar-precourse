package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RandomNumberTest {

    @Test
    @DisplayName("0~9 사이 랜덤 숫자 생성 테스트")
    void constructor() {
        RandomNumber randomNumber = new RandomNumber();

        for (int i = 0; i < 100000; i++) {
            assertThat(randomNumber.getNumber()).isLessThan(10).isGreaterThan(-1);
        }

        assertThat(new RandomNumber(4).getNumber()).isEqualTo(4);
        assertThat(new RandomNumber(9).getNumber()).isEqualTo(9);
        assertThat(new RandomNumber(0).getNumber()).isEqualTo(0);
        assertThat(catchThrowable(() -> new RandomNumber(-1))).isInstanceOf(IllegalArgumentException.class);
        assertThat(catchThrowable(() -> new RandomNumber(10))).isInstanceOf(IllegalArgumentException.class);
    }

}
