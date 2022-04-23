package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {

    @Test
    void 이름_문자열_포장() {
        // given

        // when
        Name name = new Name("pobi");
        // then
        assertThat(name.getName()).isEqualTo("pobi");
    }

    @Test
    void 이름_길이_5자리체크_오류발생() {
        // given
        // when
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name("pobiy1234"));
    }
}
