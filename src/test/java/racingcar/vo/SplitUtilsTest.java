package racingcar.vo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.utils.SplitUtils;

class SplitUtilsTest {

    @DisplayName("문자열을 delimiter로 분리한 뒤 List로 반환")
    @ParameterizedTest(name = "[{0}] 입력을 [{1}] 구분자로 분리")
    @CsvSource(value = {"메기,병아리,누리호:,:3"}, delimiter = ':')
    void splitToList(String words, String delimiter, int expectedSize) {
        List<String> splitList = SplitUtils.splitToList(words, delimiter);
        assertEquals(expectedSize, splitList.size());
    }

}