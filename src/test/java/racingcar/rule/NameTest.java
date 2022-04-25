package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class NameTest {

    @DisplayName("자동차 이름은 5자 이하만 가능하다")
    @Test
    void should5LengthOrLess() {
        //given
        String fiveLength = "apple";

        //when
        Throwable thrown = catchThrowable(() -> new Name(fiveLength));

        //then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 빈 값이거나 공백이면 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] name=\"{0}\"")
    @EmptySource
    @ValueSource(strings = " ")
    void throwExceptionWhenEmptyString(String name) {
        //when
        Throwable thrown = catchThrowable(() -> new Name(name));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 한다.");
    }

    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다")
    @Test
    void throwExceptionWhenLengthMoreThan5() {
        //given
        String sixLength = "banana";

        //when
        Throwable thrown = catchThrowable(() -> new Name(sixLength));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 한다.");
    }
}
