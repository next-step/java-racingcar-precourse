package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.Message;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RoundTest {

    @DisplayName("이동 횟수 양의 정수인지 검증 - 정상 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1234", "78"})
    void validMoveCountTest_OK(String input) {
        assertThatCode(() -> new Round(input)).doesNotThrowAnyException();
    }

    @DisplayName("이동 횟수 양의 정수인지 검증 - 에러 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"", "0", "-1", "0.23", "1qkdk", "!@dfjj"})
    void validMoveCountTest_ERR(String input) {
        assertThatThrownBy(() -> new Round(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERR_MOVECNT_FORMAT);
    }
}