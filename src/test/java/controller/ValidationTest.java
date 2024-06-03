package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidationTest {

    private final Validation validation = new Validation();

    @Test
    @DisplayName("Valid car names are under five length")
    void validateCarNameUnderFive() {
        // Given
        List<String> carNames = Arrays.asList("Bell", "Sonny", "Kane");

        // When
        boolean result = validation.validationCarName(carNames);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("InValid car names are exceed five length")
    void inValidateCarNameUnderFive() {
        // Given
        List<String> carNames = Arrays.asList("Bellingham", "Sonny", "Kane");

        // When
        boolean result = validation.validationCarName(carNames);

        // Then
        assertThat(result).isFalse();
    }



    @Test
    @DisplayName("Valid tryCount is numeric")
    void validateTryCountNumeric() {
        // Given
        String tryCount = "4";

        // When
        boolean result = validation.validationTryCount(tryCount);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Invalid tryCount is not numeric")
    void invalidateTryCountNumeric() {
        // Given
        String tryCount = "abc";

        // When
        boolean result = validation.validationTryCount(tryCount);

        // Then
        assertThat(result).isFalse();
    }

}
