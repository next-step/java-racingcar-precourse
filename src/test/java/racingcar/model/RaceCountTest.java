package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;
import racingcar.exception.InvalidRaceCountFormatException;
import racingcar.exception.InvalidRaceCountRangeException;
import racingcar.view.UserInput;

public class RaceCountTest {

    @Test
    @DisplayName("입력받은 레이스 횟수가 숫자가 아닐 경우 예외 발생")
    void invalidRaceCountAsNumber() {
        // given
        UserInput userInput = new UserInput("A");

        // then
        assertThatThrownBy(() -> new RaceCount(userInput))
                .isInstanceOf(InvalidRaceCountFormatException.class)
                .hasMessageContaining(ErrorMessage.INVALID_RACE_COUNT_FORMAT);
    }

    @ParameterizedTest(name = "사용자 입력 : {0}")
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("입력받은 레이스 횟수가 최소 시도 횟수 보다 작을 경우 예외 발생")
    void invalidRaceCountLessThanMinimumConfig(String source) {
        // given
        UserInput userInput = new UserInput(source);

        // then
        assertThatThrownBy(() -> new RaceCount(userInput))
                .isInstanceOf(InvalidRaceCountRangeException.class)
                .hasMessageContaining(ErrorMessage.INVALID_RACE_COUNT_RANGE);
    }

    @Test
    @DisplayName("입력받은 레이스 횟수가 '0'으로 시작할 경우 변환 검증")
    void trimZeroStart() {
        // given
        UserInput userInput = new UserInput("0099");

        // when
        RaceCount raceCount = new RaceCount(userInput);

        // then
        assertThat(raceCount.getValue()).isEqualTo(99);
    }

    @ParameterizedTest(name = "사용자 입력 : {0}")
    @ValueSource(strings = {"+20", "+020", "20"})
    @DisplayName("입력받은 레이스 횟수가 정상일 경우 예외가 발생하지 않음")
    void validRaceCount(String source) {
        // given
        UserInput userInput = new UserInput(source);

        // then
        assertThatNoException().isThrownBy(() -> new RaceCount(userInput));
    }
}
