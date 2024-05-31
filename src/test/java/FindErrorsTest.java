import static org.junit.jupiter.api.Assertions.*;

import Model.FindErrors;
import org.junit.jupiter.api.*;

public class FindErrorsTest {
    private FindErrors findErrors = new FindErrors();

    @Test
    public void validCarNames_LongNames() {
        String input = "pobi,woni,jun,cookies";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            findErrors.validCarNames(input);
        });
        assertEquals("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    public void validCarNames_Spacing() {
        String input = "pobi,woni,jun,co k";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            findErrors.validCarNames(input);
        });
        assertEquals("[ERROR] 자동차의 이름에 띄어쓰기가 있으면 안됩니다.", exception.getMessage());
    }
}
