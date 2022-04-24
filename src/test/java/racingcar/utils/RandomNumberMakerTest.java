package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomNumberMakerTest {
    @Test
    @DisplayName("0 ~ 9 중 하나의 랜덤값을 만드는 기능")
    @RepeatedTest(100)
    void randomNumberMake() {
        int result = RandomNumberMaker.makeNumber();

        assertThat(result<=9).isEqualTo(true);
        assertThat(result>=0).isEqualTo(true);

        assertThat(result>10).isEqualTo(false);
        assertThat(result<0).isEqualTo(false);
    }
}