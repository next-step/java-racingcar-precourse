package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationUtilsTest {

    private OutputStream captor;

    private final String ERROR_MESSAGE_PREFIX = "[ERROR]";

    @BeforeEach
    protected final void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void 자동차_이름이_공백인_경우() {
        assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateCarName(null));
    }

    @Test
    void 자동차_이름이_5글자를_초과하는_경우() {
        assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateCarName("테스트자동차"));
    }

    @Test
    void 자동차이름_콤마없이_하나만_입력할_경우() {
        String testData = "pobi";
        assertTrue(ValidationUtils.isValidCarNames(testData));
    }

    @Test
    void 자동차이름_콤마포함_하나만_입력할_경우() {
        String testData = "pobi,";
        assertTrue(ValidationUtils.isValidCarNames(testData));
    }

    @Test
    void 자동차이름_콤마만_입력할_경우() {
        String testData = ",,,";
        ValidationUtils.isValidCarNames(testData);
        assertTrue(output().startsWith(ERROR_MESSAGE_PREFIX));
    }

    @Test
    void 자동차이름_아무것도_입력하지_않은_경우() {
        ValidationUtils.isValidCarNames(null);
        assertTrue(output().startsWith(ERROR_MESSAGE_PREFIX));
    }

    @Test
    void 시도회수_아무것도_입력하지_않은_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.isValidTotalRound(null);
            assertTrue(output().startsWith(ERROR_MESSAGE_PREFIX));
        });
    }

    @Test
    void 시도회수_숫자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.isValidTotalRound("hello");
            assertTrue(output().startsWith(ERROR_MESSAGE_PREFIX));
        });
    }
}