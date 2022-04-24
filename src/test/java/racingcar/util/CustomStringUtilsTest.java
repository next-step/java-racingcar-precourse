package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.CustomUtils.stringSplitByComma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomStringUtilsTest {

    @DisplayName("문자열 쉼표 구분 시 단일 값 확인 및 공백 제거 확인")
    @Test
    void stringSplitByCommaSingleResultTest() {
        String input = "test1 ";

        String[] strArr = stringSplitByComma(input);

        assertThat(strArr.length).isEqualTo(1);
        assertThat(strArr[0]).isEqualTo(input.trim());

    }

    @DisplayName("문자열 쉼표 구분 시 다수 값 확인 및 공백 제거 확인")
    @Test
    void stringSplitByCommaMultiResultTest() {
        String input = "test1, test2,test3 ,te st4 ";
        String whiteSpaceAtEndPoint = "^[\\s]|[\\s]$";

        String[] strArr = stringSplitByComma(input);

        assertThat(strArr.length).isEqualTo(4);

        for (String str : strArr) {
            assertThat(str).doesNotContainPattern(whiteSpaceAtEndPoint);
        }

    }
}