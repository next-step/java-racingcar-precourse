package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("실행횟수 도메인 테스트")
class RoundTest {

    @ParameterizedTest(name = "실행횟수 생성")
    @ValueSource(strings = {"1", "3333"})
    void 실행횟수_생성(String input) {
        // when
        Round round = new Round(input);
        // then
        assertThat(round).isNotNull();
    }

    @ParameterizedTest(name = "실행횟수 1미만 입력시 예외발생")
    @ValueSource(strings = {"0", "-1"})
    void 실행횟수_1미만_입력시_예외발생(String input) {
        // when + then
        assertThatThrownBy(() -> new Round(input)).isInstanceOf(RoundException.InvalidRangeException.class);
    }

    @ParameterizedTest(name = "실행횟수 문자 입력시 예외발생")
    @ValueSource(strings = {"가나다", "abc", "", " "})
    void 실행횟수_문자_입력시_예외발생(String input) {
        // when + then
        assertThatThrownBy(() -> new Round(input)).isInstanceOf(RoundException.NumberFormatException.class);
    }

    @ParameterizedTest(name = "실행가능횟수 만큼 실행")
    @ValueSource(strings = {"1", "9"})
    void 실행가능횟수_만큼_실행(String input) {
        // when
        Round round = new Round(input);

        // then
        실행가능횟수_만큼_실행됨(round, Integer.parseInt(input));
    }

    @ParameterizedTest(name = "실행가능횟수 초과시 예외발생")
    @ValueSource(strings = {"1", "9"})
    void 실행가능횟수_초과시_예외발생(String input) {
        // given
        Round round = new Round(input);
        실행가능횟수_만큼_실행됨(round, Integer.parseInt(input));

        // when + then
        assertThatThrownBy(() -> round.execute()).isInstanceOf(RoundException.ExceedExecutableNumberException.class);
    }

    private void 실행가능횟수_만큼_실행됨(Round round, int executableNumber) {
        for (int i = 0; i < executableNumber; i++) {
            assertThat(round.executable()).isTrue();
            round.execute();
        }
    }

}