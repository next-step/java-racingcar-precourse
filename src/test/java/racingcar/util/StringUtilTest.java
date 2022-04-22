package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 처리기 테스트")
class StringUtilTest {

    @DisplayName("콤마(,)로 문자열 자르기 테스트")
    @Test
    void splitByCommaTest() {

        //given
        String input = "user1,user2,user3";

        //when
        String[] result = StringUtil.splitByComma(input);

        //then
        assertThat(result).hasSize(3);
    }
}
