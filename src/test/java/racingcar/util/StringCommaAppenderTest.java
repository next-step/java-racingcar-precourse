package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.StringCommaAppender;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCommaAppenderTest {

    @Test
    @DisplayName("문자열을_가지고_있는_문자열_뒤에_추가한다_(초기 문자열이 있을 경우)")
    void stringCommaInitialize() {
        StringCommaAppender stringCommaAppender = new StringCommaAppender("하하하");

        stringCommaAppender.append("호호호");
        stringCommaAppender.append("흣홯");

        assertThat(stringCommaAppender.get()).isEqualTo("하하하, 호호호, 흣홯");
    }

    @Test
    @DisplayName("문자열을_가지고_있는_문자열_뒤에_추가한다_(초기 문자열이 없을 경우)")
    void stringCommaInitializeNone() {
        StringCommaAppender stringCommaAppender = new StringCommaAppender("");

        stringCommaAppender.append("하하하");
        stringCommaAppender.append("호호호");
        stringCommaAppender.append("흣홯");

        assertThat(stringCommaAppender.get()).isEqualTo("하하하, 호호호, 흣홯");
    }
}
