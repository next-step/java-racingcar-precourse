package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @DisplayName("자동차 이름은 빈 값일 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void 자동차_이름은_빈_값일_수_없다(String name) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> new Name(name))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageStartingWith("[ERROR] 자동차 이름은 빈값일 수 없습니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "abcdefg", "sdf ds"})
    void 자동차_이름이_5자를_초과하면_예외가_발생한다(String name) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> new Name(name))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageStartingWith("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름을 조회할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"아이유", "지코", "pobi"})
    void 자동차_이름을_조회할_수_있다(String name) {
        // given
        // when
        // then
        assertThat(new Name(name).getName()).isEqualTo(name);
    }
}