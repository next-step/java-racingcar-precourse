import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import util.Validator;

public class ValidatorTest {

    @Test
    public void testValidateArrayExistence_ValidArray() {
        String[] carArray = {"Car1", "Car2"};
        Validator.validateArrayExistence(carArray);
    }

    @Test
    public void testValidateArrayExistence_EmptyArray() {
        String[] carArray = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateArrayExistence(carArray);
        });
        assertEquals("[ERROR] 1개 이상의 자동차를 입력해야 합니다.", exception.getMessage());
    }

    @Test
    public void testValidateNameLength_ValidNames() {
        String[] carArray = {"Car", "Auto"};
        Validator.validateNameLength(carArray);
    }

    @Test
    public void testValidateNameLength_NameTooLong() {
        String[] carArray = {"Car1", "Automobile"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNameLength(carArray);
        });
        assertEquals("[ERROR] 자동차의 이름은 5자 이하이어야 합니다.", exception.getMessage());
    }

    @Test
    public void testValidateNameLength_NameTooShort() {
        String[] carArray = {"", "Car2"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNameLength(carArray);
        });
        assertEquals("[ERROR] 자동차의 이름은 1자 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    public void testValidateNumberFormat_ValidNumber() {
        int result = Validator.validateNumberFormat("123");
        assertEquals(123, result);
    }

    @Test
    public void testValidateNumberFormat_InvalidNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNumberFormat("abc");
        });
        assertEquals("[ERROR] 시도할 횟수는 숫자로 입력해야 합니다.", exception.getMessage());
    }
}
