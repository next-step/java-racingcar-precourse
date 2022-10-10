package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {

    @Test
    @DisplayName("값이_1이상_9이하인_숫자를_생성한다")
    void 값이_1이상_9이하인_숫자를_생성한다() {
        int expectedMinNum = 1;
        int expectedMaxNum = 9;
        assertThat(RandomUtils.getRandomNumber()).isBetween(expectedMinNum, expectedMaxNum);
    }
}
