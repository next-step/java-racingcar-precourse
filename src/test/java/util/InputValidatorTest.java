package util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static exception.ErrorMsg.*;

class InputValidatorTest {

    @Test
    void validateCarName_ValidNames_ReturnsTrue() {
        String[] validCarNames = {"pobi", "woni", "jun"};
        assertTrue(InputValidator.validateCarName(validCarNames));
    }

    @Test
    void validateCarName_TooFewCars_ThrowsException() {
        String[] carNames = {"pobi"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarName(carNames);
        });
        assertEquals(ERROR_TOO_FEW_CARS, exception.getMessage());
    }

    @Test
    void validateCarName_EmptyName_ThrowsException() {
        String[] carNames = {"pobi", ""};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarName(carNames);
        });
        assertEquals(ERROR_EMPTY_NAME, exception.getMessage());
    }

    @Test
    void validateCarName_NameContainsSpace_ThrowsException() {
        String[] carNames = {"pobi ", "woni"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarName(carNames);
        });
        assertEquals(ERROR_SPACE_IN_NAME, exception.getMessage());
    }

    @Test
    void validateCarName_NameTooLong_ThrowsException() {
        String[] carNames = {"pobipobi", "woni"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarName(carNames);
        });
        assertEquals(ERROR_NAME_TOO_LONG, exception.getMessage());
    }

    @Test
    void validateCarName_InvalidCharacter_ThrowsException() {
        String[] carNames = {"pobi", "포비"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarName(carNames);
        });
        assertEquals(ERROR_INVALID_CHARACTER, exception.getMessage());
    }

    @Test
    void validateCarName_DuplicateName_ThrowsException() {
        String[] carNames = {"pobi", "pobi"};
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            InputValidator.validateCarName(carNames);
        });
        assertEquals(ERROR_DUPLICATE_NAME, exception.getMessage());
    }

    @Test
    void validateAttemptNum_ValidNumber_ReturnsTrue() {
        int validAttempt = 5;
        assertTrue(InputValidator.validateAttemptNum(validAttempt));
    }

    @Test
    void validateAttemptNum_InvalidNumber_ThrowsException() {
        int invalidAttempt = 0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateAttemptNum(invalidAttempt);
        });
        assertEquals(ERROR_INVALID_ATTEMPT_NUMBER, exception.getMessage());
    }
}
