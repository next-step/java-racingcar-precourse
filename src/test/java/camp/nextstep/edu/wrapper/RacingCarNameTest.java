package camp.nextstep.edu.wrapper;

import camp.nextstep.edu.constant.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingCarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcde", "가나다라마", "12345"})
    @DisplayName("레이싱카 이름 부여 - 성공 테스트")
    void racingCarName_successTest(String name) {
        // given & when
        RacingCarName racingCarName = new RacingCarName(name);

        // then
        assertThat(racingCarName.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "가나다라마바", "123456"})
    @DisplayName("레이싱카 이름 부여 - 실패 테스트")
    void racingCarName_failureTest(String name) {
        // given & when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCarName(name))
                .withMessageContaining(Message.INVALID_CAR_NAME);
    }
}
