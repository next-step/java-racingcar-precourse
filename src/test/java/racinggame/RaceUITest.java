package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RaceUITest {

    @DisplayName("유저입력검증-유효한 carName로 구성되어 있을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"sunki,pobii", "a1234,b123,c123", "g"})
    void validateCarNameInput_normal(String input) {
        //when, then
        RaceUI.validateCarNameInput(input);
    }

    @DisplayName("유저입력검증-유효하지 않은 carName이 포함되어 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", "kimsunki,pobi", "poby,kimsunki", "123456"})
    void validateCarNameInput_throwsException(String input) {
        //when, then
        assertThatExceptionOfType(RaceException.class)
                .isThrownBy(() -> RaceUI.validateCarNameInput(input))
                .withMessageContaining(RaceErrorCode.INVALID_CAR_NAME_LENGTH.message());
    }

    @DisplayName("유저입력검증-유효한 횟수 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1", "20000000", "5000"})
    void validateIterationCountInput_normal(String testCountInput) {
        RaceUI.validateIterationCountInput(testCountInput);
    }

    @DisplayName("유저입력검증-유효하지 않은 횟수 입력")
    @ParameterizedTest
    @ValueSource(strings = {"0", "abc", " ", "-5", "128372193871398"})
    void validateIterationCountInput_throwsException(String testCountInput) {
        assertThatExceptionOfType(RaceException.class)
                .isThrownBy(() -> RaceUI.validateIterationCountInput(testCountInput))
                .withMessageContaining(RaceErrorCode.INVALID_FORMAT_ITERATION_COUNT.message());
    }
}
