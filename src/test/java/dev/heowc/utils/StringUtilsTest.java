package dev.heowc.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StringUtils에 대해 테스트한다.")
class StringUtilsTest {

    @DisplayName("StringUtils.hasText()를 테스트한다.")
    @ParameterizedTest
    @MethodSource("provideHasTextMethodArguments")
    void hasText(String value, boolean expected) {
        assertThat(StringUtils.hasText(value)).isEqualTo(expected);
    }

    private static Stream<? extends Arguments> provideHasTextMethodArguments() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of("", false),
                Arguments.of("null", true),
                Arguments.of("test", true)
        );
    }

    @DisplayName("StringUtils.repeat()를 테스트한다.")
    @ParameterizedTest
    @CsvSource({
            "-,0,''",
            "-,3,---",
            "-,10,----------",
    })
    void repeat(char ch, int count, String expected) {
        assertThat(StringUtils.repeat(ch, count)).isEqualTo(expected);
    }
}