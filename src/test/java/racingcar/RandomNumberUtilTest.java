package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberUtilTest {

    @Test
    @DisplayName("0~9 사이 랜덤 값 구하기")
    void getNumber() {
        assertThat(RandomNumberUtil.getNumber()).isGreaterThanOrEqualTo(0);
        assertThat(RandomNumberUtil.getNumber()).isLessThanOrEqualTo(9);
    }

}
