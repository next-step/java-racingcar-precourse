package controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    @DisplayName("is validation class singleton pattern")
    void testGetInstance() {
        Validation validation1 = Validation.getInstance();
        Validation validation2 = Validation.getInstance();
        assertTrue(validation1.equals(validation2));
    }

    @Test
    void testValidationCarName() {

    }

    @Test
    void testValidationTryCount() {

    }
}
