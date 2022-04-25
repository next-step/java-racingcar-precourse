package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void 자동차_이름을_검증한다() {
        assertThatThrownBy(
                () -> new CarName("")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름이 존재 해야 합니다.");

        assertThatThrownBy(
                () -> new CarName("abcdef")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5 글자를 넘어갈 수 없습니다.");
    }

    @Test
    void CarName_비교() {
        assertThat(new CarName("chae")).isEqualTo(new CarName("chae"));
    }
}
