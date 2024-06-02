package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitterTest {

    @Test
    @DisplayName("구분자가 없는 문자열 split 테스트")
    void splitStringWithNoDelimiterString() {
        String testString = "NoDelimiterStringTest";
        Assertions.assertThat(String.join("", StringSplitter.splitString(testString))).isEqualTo(testString);
    }

    @Test
    @DisplayName("구분자가 있는 문자열 split 테스트")
    void splitStringWithDelimiterString() {
        String testString = "Delimiter,String,Test";
        String testStringWithoutDelimiter = "DelimiterStringTest";
        Assertions.assertThat(String.join("", StringSplitter.splitString(testString))).isEqualTo(testStringWithoutDelimiter);
    }
}