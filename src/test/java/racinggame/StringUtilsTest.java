package racinggame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.utils.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"0, pobi", "1, crong", "2, honux"})
    void 자동차이름_쉼표구분(int index, String name) {
        String inputString = "pobi,crong,honux";
        String[] nameArray = StringUtils.inputStringSeparator(inputString);
        assertThat(nameArray[index]).isEqualTo(name);
    }

    @Test
    void 입력값_빈값_에러() {
        String emptyString = "";
        assertThatThrownBy(() ->
                StringUtils.inputStringSeparator(emptyString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_널_에러() {
        String nullString = null;
        assertThatThrownBy(() ->
                StringUtils.inputStringSeparator(nullString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_에러() {
        String inputString = "pobi,crong,honuxx";
        assertThatThrownBy(() ->
                StringUtils.inputStringSeparator(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
