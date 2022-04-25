package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    @DisplayName("주어진 구분자로 문자열을 분리하여 List로 리턴한다.")
    void split_by_delimeter(){
        String givenText = "a, aa, aaa, a";
        List<String> strings = StringUtils.splitByDelimiter(givenText, ",");
        assertThat(strings).containsExactly("a", "aa", "aaa", "a");
    }
}
