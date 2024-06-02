import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {


    @Test
    void noCarName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Set.validateCarName("");
        });
        assertEquals("[ERROR] 자동차 이름은 1자 이상만 가능합니다.", exception.getMessage());
    }

    @Test
    void carNameMoreThan5() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Set.validateCarName("TooLongName");
        });
        assertEquals("[ERROR] 자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    void validCarName() {
        assertDoesNotThrow(() -> {
            Set.validateCarName("Valid");
        });
    }


    @Test
    void withInvalidNames() {
        String[] names = {"Tom", "Jerry", "VeryLongName"};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Set.validateCarName(names);
        });
        assertEquals("[ERROR] 자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    void inValidateAttempt() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Set.validateAttempt(0);
        });
        assertEquals("[ERROR] 시도 횟수는 1 이상이어야 한다.", exception.getMessage());
    }

    @Test
    void validAttempt() {
        assertDoesNotThrow(() -> {
            Set.validateAttempt(5);
        });
    }


}
