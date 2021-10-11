package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class NameTest {

    @DisplayName("자동차 이름을 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(
            () -> new Name("lewis")
        );
    }

    @DisplayName("자동차에 올바르지 않은 이름을 부여할 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void invalidName(final String value) {
        assertThatThrownBy(
            () -> new Name(value)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 최대 5자까지 입력할 수 있다.")
    @Test
    void invalidName2() {
        assertThatThrownBy(
            () -> new Name("schumacher")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 간 동등성을 비교할 수 있다.")
    @Test
    void equals() {
        final Name name1 = new Name("lewis");
        final Name name2 = new Name("lewis");

        assertThat(name1).isEqualTo(name2);
    }
}
