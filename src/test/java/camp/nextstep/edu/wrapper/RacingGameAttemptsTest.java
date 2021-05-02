package camp.nextstep.edu.wrapper;

import camp.nextstep.edu.constant.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameAttemptsTest {

    private RacingGameAttempts racingGameAttempts;

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @DisplayName("시도 횟수 설정 - 성공 테스트")
    void setAttempts_successTest(String str) {
        // given & when
        racingGameAttempts = new RacingGameAttempts(str);

        // then
        assertThat(racingGameAttempts.getAttempts()).isEqualTo(Integer.parseInt(str));
    }


    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2", "-3", "-4", "-5"})
    @DisplayName("시도 횟수 설정 - 실패 테스트")
    void setAttempts_failureTest(String str) {
        // given & when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGameAttempts(str))
                .withMessageContaining(Message.INVALID_NUMBER_OF_ATTEMPTS);
    }
}
