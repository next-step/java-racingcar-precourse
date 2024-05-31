import static org.junit.jupiter.api.Assertions.*;

import Model.FindErrors;
import org.junit.jupiter.api.*;

public class FindErrorsTest {
    private FindErrors findErrors = new FindErrors();

    @Test
    @DisplayName("5글자가 넘는 자동차 이름 입력에 대한 테스트")
    public void validCarNames_LongNames() {
        String input = "pobi,woni,jun,cookies";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            findErrors.validCarNames(input);
        });
        assertEquals("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("띄어쓰기가 있는 자동차 이름 입력에 대한 테스트")
    public void validCarNames_Spacing() {
        String input = "pobi,woni,jun,co k";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            findErrors.validCarNames(input);
        });
        assertEquals("[ERROR] 자동차의 이름에 띄어쓰기가 있으면 안됩니다.", exception.getMessage());
    }

    @Test
    @DisplayName("중복된 자동차 이름 입력에 대한 테스트")
    public void validCarNames_Duplicate() {
        String input = "pobi,woni,woni";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            findErrors.validCarNames(input);
        });
        assertEquals("[ERROR] 자동차의 이름에 중복이 있으면 안됩니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유효한 자동차 이름 입력에 대한 테스트")
    public void validCarNames(){
        String input = "pobi,woni,jun";
        assertDoesNotThrow(()-> {
            findErrors.validCarNames(input);
        });
        assertEquals("pobi,woni,jun",input);
    }

    @Test
    @DisplayName("시도 횟수 입력이 0인 경우에 대한 테스트")
    public void validAttempts_Zero(){
        int number = 0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            findErrors.validAttempts(number);
        });
        assertEquals("[ERROR] 시도 횟수는 1 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 입력이 음수인 경우에 대한 테스트")
    public void validAttempts_Neg() {
        int number = -20;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            findErrors.validAttempts(number);
        });
        assertEquals("[ERROR] 시도 횟수는 1 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유효한 시도 횟수 입력에 대한 테스트")
    public void validAttempts(){
        int number = 5;
        assertDoesNotThrow(()-> {
            findErrors.validAttempts(number);
        });
        assertEquals(5,number);
    }
}
