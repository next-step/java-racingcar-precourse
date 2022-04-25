package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void 문자열_반복_테스트() {
        String text = "123";
        String repeatText = StringUtils.repeatString(text, 2);
        String expectText = "123123";
        Assertions.assertThat(repeatText).isEqualTo(expectText);
    }

}