package racingcar.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("exception ( InvalidRacingCarNameLengthExcpetion )")
class InvalidRacingCarNameLengthExceptionTest {

    @Test
    @DisplayName("지정된 에러 속성인지 확인 - CarNameException")
    void invalid_racing_car_name_length_instanceof_test() {
        // When && Then
        assertThat(new InvalidRacingCarNameLengthException("") instanceof CarNameException).isTrue();
    }
}