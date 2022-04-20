package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class NameTest {
    @Test
    void 이름은_5자_이하() {
        Name name = new Name("다섯자이하");
        assertThat(name.getText()).isEqualTo("다섯자이하");
    }

    @Test
    void 이름이_5자_초과일시_에러() {
        final Throwable when = catchThrowable(() -> new Name("여섯자이상확인"));
        assertThat(when)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }
}
