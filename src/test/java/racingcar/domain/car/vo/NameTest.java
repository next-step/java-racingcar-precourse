package racingcar.domain.car.vo;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 인스턴스가_생성된다() {
        assertThatCode(() -> new Name("pobi"))
            .doesNotThrowAnyException();
    }

    @Test
    void 이름이_5자_이상일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Name("pobi12"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 이름이_공백일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Name(" "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 이름은 공백일 수 없습니다.");
    }
}
