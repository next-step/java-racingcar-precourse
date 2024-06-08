import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validateCarNames() {
        assertDoesNotThrow(() -> Validator.validateCarNames("2kws,2njs,qwea"));
        assertDoesNotThrow(() -> Validator.validateCarNames("joon,hsj,cho"));
        assertDoesNotThrow(() -> Validator.validateCarNames("we,hgs,ccd"));
        assertDoesNotThrow(() -> Validator.validateCarNames("abcde,abcd,abc"));

        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(",,se"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames("abcdef,abcde,abcd"));
        assertThrows(IllegalStateException.class, () -> Validator.validateCarNames("abcde,abcde,abcd"));

    }

    @Test
    void validateRepeatNumber() {
        assertDoesNotThrow(() -> Validator.validateRepeatNumber(10));

        assertThrows(IllegalArgumentException.class, () -> Validator.validateRepeatNumber(-10));
    }
}