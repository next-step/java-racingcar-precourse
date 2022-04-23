package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameParseTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc,ddd,ccc", "test,you,and,four"})
    @DisplayName("이름 파서 동작 테스트")
    void parseName(String input) {
        String[] splitResult = input.split(",");
        String[] parseResult = NameParse.parseName(input);

        Assertions.assertThat(splitResult).isEqualTo(parseResult);
    }

    @Test
    @DisplayName("사용자의 입력값이 0일 경우 예외 발생")
    void input_isBlank_IllegalArgumentException() {

        Assertions.assertThatThrownBy(() -> NameParse.parseName(null))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> NameParse.parseName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 중복된 이름을 입력할 경우 예외 발생")
    void input_isDuplicate_IllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> NameParse.parseName("aaa,bbb,ccc,ddd,aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}