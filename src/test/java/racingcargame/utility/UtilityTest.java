package racingcargame.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UtilityTest {

    @Test
    @DisplayName("랜덤으로 발생한 정수가 0 이상 10 미만이다.")
    void generateSingleDigitIntegerTest() {
        // given, when
        Integer randomSingleDigitInteger = Utility.generateRandomSingleDigitInteger();

        // then
        assertThat(randomSingleDigitInteger).isInstanceOf(Integer.class);
        assertThat(randomSingleDigitInteger < 10).isTrue();
        assertThat(randomSingleDigitInteger >= 0).isTrue();
    }
}