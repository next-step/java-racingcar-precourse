package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("길이가 1자 미만인 이름은 에러를 발생시킨다")
    void 길이가_1자_미만인_이름은_에러를_발생시킨다() {
        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("길이가 5자를 초과하는 이름은 에러를 발생시킨다")
    void 길이가_5자를_초과하는_이름은_에러를_발생시킨다() {
        assertThatThrownBy(() -> {
            new Name("myname");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

}
