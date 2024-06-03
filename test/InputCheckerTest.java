package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.InputChecker;

public class InputCheckerTest {

    private InputChecker inputChecker = new InputChecker();

    @Test
    public void testCheckNameValid() {
        String[] validNames = {"Car1", "Car2", "Car3"};
        assertDoesNotThrow(() -> inputChecker.checkName(validNames));
    }

    @Test
    public void testCheckNameInvalid() {
        String[] invalidNames = {"CarOne", "CarTwo", "CarThreeeeee"};
        assertThrows(IllegalArgumentException.class, () -> inputChecker.checkName(invalidNames));
    }

    @Test
    public void testCheckNumberValid() {
        String validNumber = "5";
        assertDoesNotThrow(() -> inputChecker.checkNumber(validNumber));
    }

    @Test
    public void testCheckNumberInvalid() {
        String invalidNumber = "five";
        assertThrows(IllegalArgumentException.class, () -> inputChecker.checkNumber(invalidNumber));
    }
}
