package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.NameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("이름 도메인 테스트")
class NameTest {

    @ParameterizedTest(name = "한자리 이상 다섯자 이하의 이름 생성")
    @ValueSource(strings = {"abcde", "1234", "일이삼사오"})
    void 한자리_이상_다섯자_이하의_이름_생성(String input) {
        // when
        Name name = new Name(input);
        // then
        assertThat(name.asString()).isEqualTo(input);
        assertThat(name.getLength()).isBetween(1, 5);
    }

    @ParameterizedTest(name = "범위초과시 예외발생")
    @ValueSource(strings = {"abcdef", ""})
    void 범위초과시_예외발생(String input) {
        // when + then
        assertThatThrownBy(() -> new Name(input)).isInstanceOf(NameException.InvalidLengthException.class);
    }

    @ParameterizedTest(name = "유효하지 않은 문자열 예외발생")
    @ValueSource(strings = {"ab,cd", ","})
    void 유효하지_않은_문자열_예외발생(String input) {
        // when + then
        assertThatThrownBy(() -> new Name(input)).isInstanceOf(NameException.InvalidCharacterException.class);
    }

}