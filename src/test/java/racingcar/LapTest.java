package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LapTest {
    private Lap lap;

    @BeforeEach
    void beforeEach() {
        lap = new Lap();
    }

    @Test
    void setLap() {
        Assertions.assertDoesNotThrow(
                () -> lap.setLap("1")
        );
    }

    @Test
    void setLap_0이하의수입력() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> lap.setLap("0")
        );
    }

    @Test
    void setLap_문자입력() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> lap.setLap("a")
        );
    }

    @Test
    void setLap_null입력() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> lap.setLap(null)
        );
    }

    @Test
    void setLap_긴숫자입력() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> lap.setLap("1111111111111111111111")
        );
    }

    @Test
    void getLapCount() {
        int lapCount = 3;
        lap.setLap(String.valueOf(lapCount));
        Assertions.assertEquals(lapCount, lap.getLapCount());
    }

    @Test
    void isNotEmpty() {
        int lapCount = 3;
        lap.setLap(String.valueOf(lapCount));
        Assertions.assertTrue(lap.isNotEmpty());
    }
}