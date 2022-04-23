package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"carl", "a", "bee", "tests"})
    @DisplayName("자동차 이름을 등록한다.")
    void create(String input) {
        Name name = Name.from(input);
        Assertions.assertThat(name.getName()).isEqualTo(input);
    }

    @Test
    @DisplayName("자동차 이름이 Null 또는 공백일 경우 예외 발생")
    void name_isBlank_IllegalArgumentException() {
        String nullName = null;
        String emptyName = "";

        Assertions.assertThatThrownBy(() -> Name.from(nullName))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> Name.from(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과할 경우 예외 발생")
    void name_isOver5Length_IllegalArgumentException() {
        //given
        String failName = "racing";

        Assertions.assertThatThrownBy(() -> Name.from(failName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}