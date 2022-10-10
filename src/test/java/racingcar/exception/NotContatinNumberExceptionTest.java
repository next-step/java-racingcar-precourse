package racingcar.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("exception ( NotContainNumberException )")
class NotContatinNumberExceptionTest {

    @Test
    @DisplayName("지정된 에러 속성인지 확인 - IllegalArgumentException")
    void not_contain_number_instanceof_test() {
        // When && Then
        assertThat(new NotContatinNumberException("") instanceof IllegalArgumentException).isTrue();
    }
}