import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Validator;

public class ValidatorTest {

    @Test
    @DisplayName("배열의 크기가 2일 때 정상적으로 validate 하는지 확인")
    public void testValidateArrayExistence_ValidArray() {
        String[] carArray = {"Car1", "Car2"};
        Validator.validateArrayExistence(carArray);
    }

    @Test
    @DisplayName("배열에 아무 요소가 없을 때 에러메시지 정상적으로 출력하는지 확인")
    public void testValidateArrayExistence_EmptyArray() {
        String[] carArray = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateArrayExistence(carArray);
        });
        assertEquals("[ERROR] 1개 이상의 자동차를 입력해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("배열 요소들의 문자열 길이가 적절한지 확인")
    public void testValidateNameLength_ValidNames() {
        String[] carArray = {"Car", "Auto"};
        Validator.validateNameLength(carArray);
    }

    @Test
    @DisplayName("5자 이상 초과한 요소에 대해 에러 발생하는지 확인")
    public void testValidateNameLength_NameTooLong() {
        String[] carArray = {"Car1", "Automobile"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNameLength(carArray);
        });
        assertEquals("[ERROR] 자동차의 이름은 5자 이하이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("문자열 길이 1 미만인 요소에 대해 에러 발생하는지 확인")
    public void testValidateNameLength_NameTooShort() {
        String[] carArray = {"", "Car2"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNameLength(carArray);
        });
        assertEquals("[ERROR] 자동차의 이름은 1자 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("입력으로 받은 문자열이 숫자로 변환하는 기능 작동 확인")
    public void testValidateNumberFormat_ValidNumber() {
        int result = Validator.validateNumberFormat("123");
        assertEquals(123, result);
    }

    @Test
    @DisplayName("숫자가 아닌 데이터가 시도할 횟수로 입력될 때 에러 발생하는지 확인")
    public void testValidateNumberFormat_InvalidNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNumberFormat("abc");
        });
        assertEquals("[ERROR] 시도할 횟수는 숫자로 입력해야 합니다.", exception.getMessage());
    }
}
