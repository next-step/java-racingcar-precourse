package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void 이름이같다() {
        Name position = new Name("pobi");
        assertThat(position).isEqualTo(new Name("pobi"));
    }

    @Test
    void 이름이다르다() {
        Name position = new Name("pobi");
        assertThat(position).isNotEqualTo(new Name("dooly"));
    }

    @Test
    void 이름빈값이면오류발생() {
        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름6글자이상이면오류발생() {
        assertThatThrownBy(() -> {
            new Name("rpgworld");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}