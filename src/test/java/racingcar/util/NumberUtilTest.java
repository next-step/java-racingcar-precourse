package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilTest {
    @Test
    @DisplayName("숫자_패턴_검증")
    public void 숫자_패턴_검증() {
        assertTrue(NumberUtil.isNumber("1234"));
        assertFalse(NumberUtil.isNumber("테스트"));
    }
}
