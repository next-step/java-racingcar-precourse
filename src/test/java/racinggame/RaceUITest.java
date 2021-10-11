package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RaceUITest {

    @DisplayName("유저입력검증-유효한 carName로 구성되어 있을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"sunki,pobii", "a12345,b1234,c1234", "good-job"})
    void validateCarNameInput_normal(String input) {
        //given
        final String[] testCarNameInput = input.split(",");
        //when, then
        RaceUI.validateCarNameInput(testCarNameInput);
    }

    @DisplayName("유저입력검증-유효하지 않은 carName이 포함되어 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"sunki,pobi", "poby,sunki", "1234"})
    void validateCarNameInput_throwsException(String input) {
        //given
        final String[] testCarNameInput = input.split(",");
        //when, then
        assertThatExceptionOfType(RaceException.class)
                .isThrownBy(() -> RaceUI.validateCarNameInput(testCarNameInput))
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
