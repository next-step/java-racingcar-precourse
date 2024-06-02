package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    
    @Test
    @DisplayName("자동차 이름을 아무것도 입력하기 않은 경우")
    public void testValidateCarNamesEmpty() {
        String[] carNames = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));
        assertEquals("[ERROR] 적어도 하나의 자동차 이름을 입력해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름으로 빈 문자열로 입력한 경우")
    public void testValidateCarNamesEmptyString() {
        String[] carNames = {"pobi", ""};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));
        assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름으로 공백을 입력한 경우")
    public void testValidateCarNamesBlank() {
        String[] carNames = {" "};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));
        assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름으로 5자를 초과하는 문자열을 입력한 경우")
    public void testValidateCarNamesLongString() {
        String[] carNames = {"pobiwonijun"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(carNames));
        assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("경기 횟수로 0을 입력한 경우")
    public void testValidateMovesZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateMoves("0"));
        assertEquals("[ERROR] 시도 횟수는 1회 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("경기 횟수로 숫자가 아닌 값을 입력한 경우")
    public void testValidateMovesNotNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateMoves("test"));
        assertEquals("[ERROR] 시도 횟수는 숫자여야 합니다.", exception.getMessage());
    }
}
