package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void Name_생성() {
        assertThat(new Name("jin")).isEqualTo(new Name("jin"));
    }

    @Test
    void 예외테스트_이름_없는경우() {
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외테스트_이름_5자초과_경우() {
        assertThatThrownBy(() -> new Name("abcder")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외테스트_이름_null인경우() {
        assertThatThrownBy(() -> new Name(null)).isInstanceOf(IllegalArgumentException.class);
    }

}