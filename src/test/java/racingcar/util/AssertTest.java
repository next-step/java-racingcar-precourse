package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class AssertTest {

    @DisplayName("notNull 메소드는 값이 null 인 경우 IllegalArgumentException 을 던진다.")
    @Test
    void notNull() {
        assertThatNoException()
                .isThrownBy(() -> Assert.notNull(new Object(), ""));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Assert.notNull(null, ""));
    }

    @DisplayName("notEmpty 메소드는 값이 null 또는 비어있는 경우 IllegalArgumentException 을 던진다.")
    @Test
    void notEmpty() {
        assertThatNoException()
                .isThrownBy(() -> Assert.notNull(Arrays.asList(1, 2, 3), ""));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Assert.notEmpty(null, ""));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Assert.notEmpty(Collections.emptyList(), ""));
    }

    @DisplayName("notLessThan 메소드는 값이 기준 값 미만인 경우, IllegalArgumentException 을 던진다.")
    @Test
    void notLessThan() {
        assertThatNoException()
                .isThrownBy(() -> Assert.notLessThan(2, 1, ""));
        assertThatNoException()
                .isThrownBy(() -> Assert.notLessThan(1, 1, ""));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Assert.notLessThan(1, 2, ""));
    }

    @DisplayName("notMoreThan 메소드는 값이 기준 값 초과인 경우, IllegalArgumentException 을 던진다.")
    @Test
    void notMoreThan() {
        assertThatNoException()
                .isThrownBy(() -> Assert.notMoreThan(1, 2, ""));
        assertThatNoException()
                .isThrownBy(() -> Assert.notMoreThan(1, 1, ""));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Assert.notMoreThan(2, 1, ""));
    }

    @DisplayName("notMoreThan 메소드는 값이 중복 된 경우, IllegalArgumentException 을 던진다.")
    @Test
    void notDuplicated() {
        assertThatNoException()
                .isThrownBy(() -> Assert.notDuplicated(Arrays.asList(1, 2, 3), ""));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Assert.notDuplicated(Arrays.asList(1, 1, 1), ""));
    }
}