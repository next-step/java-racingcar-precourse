package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Name.*;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 이름_클래스_생성_및_이름반환() {
        String nameString = "test";
        Name name = new Name(nameString);
        assertThat(name.getNameString()).isEqualTo(nameString);
    }

    @Test
    void 이름_검증() {
        assertThatThrownBy(() -> new Name("123456"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_ERROR_CAR_NAME);
        assertThatThrownBy(() -> new Name(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_ERROR_CAR_NAME);
    }
}