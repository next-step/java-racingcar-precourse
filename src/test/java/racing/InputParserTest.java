package racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    @Test
    void parseName_shouldParseCarName() {
        String inputNames = "abc,def,ghi";
        CarSet expect = new CarSet(new Car("abc"), new Car("def"), new Car("ghi"));

        CarSet actual = InputParser.parseCarNames(inputNames);

        Assertions.assertEquals(actual, expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc,defghi", "abc,def,,ghi", ""})
    void parseName_shouldThrowAbnormalInput(String inputNames) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames(inputNames));
    }


    @Test
    void parseRounds_shouldParseRounds() {
        String inputRound = "10";
        Round expect = new Round(10);
        Round actual = InputParser.parseRound(inputRound);

        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "", "1A"})
    void parseRounds_shouldThrowNotNumericInput(String inputRound) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseRound(inputRound)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "11"})
    void parseRounds_shouldThrowNotInRange(String inputRound) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputParser.parseRound(inputRound));
    }
}
