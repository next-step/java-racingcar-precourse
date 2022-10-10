package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class racingcarsNameTest {
    @Test
    void 자동차이름_여러개_길이_제한_5이상() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                new racingcarsName(Arrays.asList(new racingcarName("fobiiiiii"), new racingcarName("crong"), new racingcarName("honux"))));
        assertEquals("[ERROR] 자동차 이름의 길이가 5를 넘었습니다.", e.getMessage());
    }
    @Test
    void 자동차이름_여러개_길이_제한_0이하() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                new racingcarsName(Arrays.asList(new racingcarName("fobii"), new racingcarName(""), new racingcarName("honux"))));
        assertEquals("[ERROR] 자동차 이름을 입력하지 않았습니다.", e.getMessage());
    }
}
