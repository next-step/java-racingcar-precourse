package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TypeTransformerTest {
    @Test
    @DisplayName("문자열을 seperator를 기준으로 분리하여 배열로 변경")
    void test() {
        // given
        String input = "a,b,c,d,e,f,g";

        // when
        String[] result = TypeTransformer.changeString2Array(input, ",");

        // then
        assertThat(result).contains("a");
        assertThat(result).contains("e");
        assertThat(result.length).isEqualTo(7);
    }

    @Test
    @DisplayName("문자열을 `,` 를 기준으로 분리하여 배열로 변경")
    void test2() {
        // given
        String input = "a,b,c,d,e,f,g";

        // when
        String[] result = TypeTransformer.changeString2Array(input);

        // then
        assertThat(result).contains("a");
        assertThat(result).contains("e");
        assertThat(result.length).isEqualTo(7);
    }
}