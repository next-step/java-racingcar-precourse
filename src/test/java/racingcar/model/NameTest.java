package racingcar.model;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NameTest {
    @ParameterizedTest
    @DisplayName("글자수 유효성 검사 : 1 ~ 5글자 허용")
    @ValueSource(strings = {"name~", "t"})
    void validateNameSize(String name) {
        AssertionsForClassTypes.assertThat(Name.validateNameSize(name)).isTrue();
    }

    @Test
    void 글자_유효성_검사_실패_이름크기_0() {
        assertThat(Name.validateNameSize("")).isFalse();
    }

    @Test
    void 글자_유효성_검사_실패_이름크기_6이상() {
        assertThat(Name.validateNameSize("naming")).isFalse();
    }
}
