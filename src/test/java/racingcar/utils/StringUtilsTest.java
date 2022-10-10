package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class StringUtilsTest {

    @DisplayName("null 또는 공백 문자열이 입력되면 예외를 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void StringTestWhenNullOrEmpty(String input) {
        assertThatThrownBy(() -> {
            StringUtil.validateNullAndEmpty(StringUtil.isNullOrEmpty(input));
        }).isInstanceOf(RuntimeException.class);
    }


}
