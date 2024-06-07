package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("빈 입력 값일 경우 IllegalArgumentException을 던진다")
    void testCheckEmptyInput() {
        // 빈 입력 값 테스트
        assertThatThrownBy(() -> validator.checkCarNamesInput(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값이 비어있습니다. 다시 입력해 주세요");

        assertThatThrownBy(() -> validator.checkCarNamesInput("   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값이 비어있습니다. 다시 입력해 주세요");
    }

    @Test
    @DisplayName("공백 이름이 포함된 경우 IllegalArgumentException을 던진다")
    void testCheckEmptyName() {
        // 공백 이름 테스트
        assertThatThrownBy(() -> validator.checkCarNamesInput("car1, ,car3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("공백은 자동차 이름이 될 수 없습니다. 다시 입력해 주세요");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 IllegalArgumentException을 던진다")
    void testCheckNameLength() {
        // 이름 길이 테스트
        assertThatThrownBy(() -> validator.checkCarNamesInput("car1,toolongname,car3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("유효한 입력 값일 경우 예외를 던지지 않는다")
    void testValidInput() {
        // 유효한 입력 값 테스트
        assertDoesNotThrow(() -> validator.checkCarNamesInput("car1,car2,car3"));
    }
}
