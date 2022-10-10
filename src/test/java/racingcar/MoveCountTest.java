package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.MoveCount;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Constants.ErrorMessage.ERR_MSG_TITLE;

class MoveCountTest {

    private final String EXPECTED_CONTAINING_ERR_MSG = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"", "0", "a"})
    @DisplayName("자동차 이동 횟수 테스트")
    public void validateMoveCountTest_invalidValue(String given){
        //when then
        assertThatThrownBy(
                () -> {
                    new MoveCount(given);
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ERR_MSG_TITLE);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("자동차 이동 횟수 테스트")
    public void validateMoveCountTest_null(String given){
        //when then
        assertThatThrownBy(
                () -> {
                    new MoveCount(given);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERR_MSG_TITLE);
    }

}