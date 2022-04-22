package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TimesTest {

    @Test
    public void 정상() {
        assertAll(() -> new Times("1"));
    }

    @Test
    public void 비정상_문자() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Times("문자"));
    }

}