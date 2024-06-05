package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesParserTest {
    @Test
    @DisplayName("parseCarNames test")
    void parseCarNamesTest() throws Exception {
        // given
        String input = "pobi,woni,jun";
        List<String> expected = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));

        // when
        List<String> result = CarNamesParser.parse(input);

        // then
        assertThat(result).isEqualTo(expected);

    }
}