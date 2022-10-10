package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    @DisplayName("Name 클래스를 생성한다.")
    @Test
    void construct() {
        Name name = new Name("car1");
        assertThat(name).isNotNull();
    }

    @DisplayName("자동차 이름 값을 trim 해서 생성한다.")
    @Test
    void trim() {
        Name name = new Name("  car1  ");
        assertThat(name).isEqualTo(new Name("car1"));
    }

    @DisplayName("빈값으로 Name 클래스를 생성하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void constructWithBlankName(String blankName) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(blankName))
                .withMessageContaining("자동차 이름은 빈값이 될 수 없습니다.");
    }

    @DisplayName("자동차 이름을 5글자 초과로 입력하였을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"letter", "moreThanFiveCharaters"})
    void constructMoreThanFiveCharacters(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name))
                .withMessageContaining("자동차 이름은 5글자 이하만 가능합니다.");
    }
}
