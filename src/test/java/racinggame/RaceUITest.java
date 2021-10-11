package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RaceUITest {

    @DisplayName("입력검증-유효한 carName로 구성되어 있을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"sunki,pobii", "a12345,b1234,c1234", "good-job"})
    void validateCarNameInput_normal(String input) {
        //given
        final String[] testInput = input.split(",");
        //when, then
        RaceUI.validateCarNameInput(testInput);
    }

    @DisplayName("입력검증-유효하지 않은 carName이 포함되어 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"sunki,pobi", "poby,sunki", "1234"})
    void validateCarNameInput_throwsException(String input) {
        //given
        final String[] testInput = input.split(",");
        //when, then
        assertThatExceptionOfType(RaceException.class)
                .isThrownBy(() -> RaceUI.validateCarNameInput(testInput))
                .withMessageContaining(RaceErrorCode.INVALID_CAR_NAME_LENGTH.message());
    }
}
