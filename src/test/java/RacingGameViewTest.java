import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.RacingGameView;
import static org.junit.jupiter.api.Assertions.*;


public class RacingGameViewTest {
    RacingGameView view = new RacingGameView();

    @DisplayName("자동차 이름 규칙에 맞을 때 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3", "carA,carB", "carX,carY,carZ"})
    void testIsValidateCarNameInput_valid(String input) {
        assertDoesNotThrow(() -> view.isValidateCarNameInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,carname2,car3", "longname1,longname2", "carX,toolongnameY"})
    void testIsValidateCarNameInput_invalid(String input) {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> view.isValidateCarNameInput(input),
                "[ERROR] 이름은 5자 이하만 가능합니다."
        );
        assertEquals("[ERROR] 이름은 5자 이하만 가능합니다.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "67890", "11111"})
    void testIsValidateAttemptCountInput_valid(String input) {
        assertDoesNotThrow(() -> view.isValidateAttemptCountInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123a5", "67b90", "11c11"})
    void testIsValidateAttemptCountInput_invalid(String input) {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> view.isValidateAttemptCountInput(input),
                "[ERROR] 숫자만 입력 가능합니다."
        );
        assertEquals("[ERROR] 숫자만 입력 가능합니다.", thrown.getMessage());
    }
}
