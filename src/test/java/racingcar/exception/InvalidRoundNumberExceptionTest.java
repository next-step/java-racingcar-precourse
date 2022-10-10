package racingcar.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("exception ( InvalidRoundNumberExcpetion )")
class InvalidRoundNumberExceptionTest {

    @Test
    @DisplayName("지정된 에러 속성인지 확인 - IllegalArgumentException")
    void invalid_round_number_instanceof_test() {
        // When && Then
        assertThat(new InvalidRoundNumberException("") instanceof IllegalArgumentException).isTrue();
    }
}