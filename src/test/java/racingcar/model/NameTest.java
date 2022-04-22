package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    public void 글자수_체크_테스트(){
        assertThatThrownBy(() -> new Name("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void null_체크_테스트(){
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name(null)).isInstanceOf(IllegalArgumentException.class);
    }

}