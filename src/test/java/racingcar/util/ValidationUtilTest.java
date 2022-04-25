package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationUtilTest {

    @Test
    @DisplayName("검증_테스트")
    void 검증_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        ValidationUtil.validation(false, "실패")).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
