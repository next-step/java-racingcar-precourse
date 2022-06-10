package racingcar.utilTest;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtil {

    @Test
    @DisplayName("splitText Test")
    void splitText_Test() throws IllegalArgumentException{
        // given
        String[] strings = StringUtil.splitText("하하, 하하1, 하하3");
        // when, then
        assertThat(strings.length).isNotNull();
        assertThat(strings.length).isEqualTo(3);
        assertThat(strings).isEqualTo(new String[] {"하하","하하1","하하3"});
    }

    @Test
    @DisplayName("random Number Test")
    void random_Number_Test() {
        // given
        final int i = Randoms.pickNumberInRange(0, 9);
        // when then
        System.out.println("i = " + i);
    }
}
