package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.StringUtils.convertListToString;
import static racingcar.utils.StringUtils.convertStringToArray;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    private static final String DELIMITER = ",";

    @Test
    void 문자열리스트를_문자열로_합침() {
        List<String> stringList = Arrays.asList("pobi", "crong", "honux");
        String expectedString = "pobi,crong,honux";
        assertThat(convertListToString(stringList, DELIMITER)).isEqualTo(expectedString);
    }

    @Test
    void 구분자로_문자열을_나눔() {
        String[] expectedArray = {"pobi", "crong", "honux"};
        String regex = "pobi,crong,honux";
        assertThat(convertStringToArray(regex, DELIMITER)).usingRecursiveComparison().isEqualTo(expectedArray);
    }
}
