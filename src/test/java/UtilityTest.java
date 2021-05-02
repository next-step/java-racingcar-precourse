import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {


    @Test
    void generateSingleDigitIntegerTest() {
        // given
        Integer randomSingleDigitInteger = Utility.generateRandomSingleDigitInteger();

        assertThat(randomSingleDigitInteger).isInstanceOf(Integer.class);
        assertThat(randomSingleDigitInteger < 10).isTrue();
        assertThat(randomSingleDigitInteger > 0).isTrue();
    }
}