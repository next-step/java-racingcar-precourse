package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameUtilTest {
    @Test
    @DisplayName("repeatString() 3과 문자열을 넘기면, 문자열이 3번 반복")
    void repeatString_Pass3AndString_StringRepeated3Times() {
        String s = GameUtil.repeatString(3, "a");

        assertThat(s).isEqualTo("aaa");
    }
}
