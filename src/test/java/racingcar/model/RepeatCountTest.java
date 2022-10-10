package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepeatCountTest {
    @Test
    void wrongRepeatCountCreateTest() {
        String input = "0";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RepeatCount repeatCount = new RepeatCount(input);
        });
    }

    @Test
    void repeatCountCreateTest() {
        String input = "1";
        RepeatCount repeatCount = new RepeatCount(input);
    }

    @Test
    void wordRepeatCountCreateTest() {
        String input = "hello";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RepeatCount repeatCount = new RepeatCount(input);
        });
    }
}
