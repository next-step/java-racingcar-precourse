package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @DisplayName("자동차 이름 일급 컬렉션을 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(
            () -> new Names("pobi,crong,honux")
        );
    }

    @DisplayName("쉼표(,) 기준으로 구분된 이름을 분리할 수 있다.")
    @Test
    void split() {
        final Names names = new Names("pobi,crong,honux");
        assertThat(names.getNames().size()).isEqualTo(3);
    }
}
