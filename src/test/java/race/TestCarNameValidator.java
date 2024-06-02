package race;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import validator.CarNameValidator;

public class TestCarNameValidator {
    CarNameValidator carNameValidator = new CarNameValidator();

    @DisplayName("자동차 이름 예외 처리 검증 : 이름길이 < 1")
    @Test
    public void throwExceptionWhenGetShortName() {

        assertThrows(IllegalArgumentException.class,
            () -> carNameValidator.test(new ArrayList<>(Arrays.asList(""))));

        assertThrows(IllegalArgumentException.class,
            () -> carNameValidator.test(new ArrayList<>(Arrays.asList("   "))));

    }

    @DisplayName("자동차 이름 예외 처리 검증 : 이름길이 > 5")
    @Test
    public void throwExceptionWhenGetLongName() {

        assertThrows(IllegalArgumentException.class,
            () -> carNameValidator.test(new ArrayList<>(Arrays.asList("123456"))));

    }

    @DisplayName("정상적인 자동차 이름 검증")
    @Test
    public void doesNotThrowException() {
        assertDoesNotThrow(
            () -> carNameValidator.test(new ArrayList<>(List.of("12345"))));

        assertDoesNotThrow(
            () -> carNameValidator.test(new ArrayList<>(List.of("ABC"))));

        assertDoesNotThrow(
            () -> carNameValidator.test(new ArrayList<>(List.of("A B C"))));

    }
}
