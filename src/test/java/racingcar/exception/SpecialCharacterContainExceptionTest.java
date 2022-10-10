package racingcar.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("exception ( SpecialCharacterContainException )")
class SpecialCharacterContainExceptionTest {

    @Test
    @DisplayName("지정된 에러 속성인지 확인 - CarNameException")
    void special_character_contain_instanceof_test() {
        // When && Then
        assertThat(new SpecialCharacterContainException("") instanceof CarNameException).isTrue();
    }
}