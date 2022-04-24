package racingcar.model.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {
    @Test
    void 문자열_중복_체크() {
        // given
        Validation validation = new Validation();
        String[] str = {"pobi", "dobi", "pobi"};
        // when
        // then
        ;
        assertThat(validation.isDuplicated(str)).isEqualTo(true);
    }
}
