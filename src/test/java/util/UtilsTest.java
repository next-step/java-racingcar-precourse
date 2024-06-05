package util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    @Test
    @DisplayName("parseCarNames test")
    void parseCarNamesTest() throws Exception {
        // given
        String input = "pobi,woni,jun";
        List<String> expected = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));

        // when
        List<String> result = Utils.parseCarNames(input);

        // then
        assertThat(result).isEqualTo(expected);

    }
}