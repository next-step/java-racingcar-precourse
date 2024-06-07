package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {
    @Test
    @DisplayName("0~9 사이의 숫자가 생성되는 지 확인")
    void isRandomNumberBetweenZeroAndNine() throws Exception {
        // when
        int result = Utils.getRandomNumber();

        // then
        assertThat(result).isBetween(0, 9);
    }
}
