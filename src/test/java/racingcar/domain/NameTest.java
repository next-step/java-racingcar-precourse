package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    void 자동차_이름은_공백이거나_5자를_초과할_수_없다() {
        new Name("sonat");
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(null));
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(""));
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("sonata"));
    }
}
