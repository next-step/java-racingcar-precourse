package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.exception.CustomIllegalArgumentException;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차이름_검증() {
        assertThatThrownBy(() ->
                new Car("", 0)
        ).isInstanceOf(CustomIllegalArgumentException.class).hasMessageContaining("1자 이상 5자 이하");
    }

    @Test
    void 자동차이름_공백() {
        assertThatThrownBy(() ->
                new Car(" ", 0)
        ).isInstanceOf(CustomIllegalArgumentException.class).hasMessageContaining("공백이 포함");
    }

    @Test
    void 자동차이름_중복() {
        assertThatThrownBy(() ->
                new Cars("a,b,a")
        ).isInstanceOf(CustomIllegalArgumentException.class).hasMessageContaining("중복");
    }
}
