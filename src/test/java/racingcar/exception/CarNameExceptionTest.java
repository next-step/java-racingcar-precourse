package racingcar.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("exception ( CarNameException )")
class CarNameExceptionTest {

    @Test
    @DisplayName("지정된 에러 속성인지 확인 - illegalArgumentExcpetion")
    void car_name_exception_instanceof_test() {
        // When && Then
        assertThat(new CarNameException("") instanceof IllegalArgumentException).isTrue();
    }
}