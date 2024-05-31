package validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void testValidNameLength() {
        // given
        String[] testCars = {"pobi", "jun", "eclipse"};

        // when // then
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validNameLength(testCars));
    }
}