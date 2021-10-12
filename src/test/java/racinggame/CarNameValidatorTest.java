package racinggame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void 자동차_이름의_길이가_1자_이상_5자_이하인_경우_유효성_검증을_통과한다(String name) {
        assertThatCode(() -> CarNameValidator.validate(name)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    void 자동차_이름이_null_또는_공백일_경우_예외를_던진다(String name) {
        assertThatThrownBy(() -> CarNameValidator.validate(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름의 길이는 1~5자 사이의 값만 허용됩니다");
    }

    @Test
    void 자동차_이름의_길이가_5자를_초과할_경우_예외를_던진다() {
        assertThatThrownBy(() -> CarNameValidator.validate("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름의 길이는 1~5자 사이의 값만 허용됩니다");
    }
}
