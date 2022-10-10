package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;

public class InputValidatorTest {
    @Test
    void wrongInputTest() {
        String notANumber = "hello";
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidator.isNumber(notANumber));
    }

    @Test
    void rightInputTest() {
        String number = "1";
        InputValidator.isNumber(number);
    }

    @Test
    void wrongRangeTest() {
        String number = "0";
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidator.isNumberInRange(number));
    }
}
