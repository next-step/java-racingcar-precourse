import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UtilityTest {


    @Test
    void generateSingleDigitIntegerTest() {
        // given, when
        Integer randomSingleDigitInteger = Utility.generateRandomSingleDigitInteger();

        // then
        assertThat(randomSingleDigitInteger).isInstanceOf(Integer.class);
        assertThat(randomSingleDigitInteger < 10).isTrue();
        assertThat(randomSingleDigitInteger >= 0).isTrue();
    }
}