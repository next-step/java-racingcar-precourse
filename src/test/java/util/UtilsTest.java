package util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {
    @Test
    @DisplayName("generateRandomNumber test")
    void generateRandomNumberTest() throws Exception {
        // when
        int result = Utils.generateRandomNumber();

        // then
        assertThat(result).isBetween(0, 9);
    }
}