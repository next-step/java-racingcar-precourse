package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

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
    void 횟수가_0인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game("pobi", 0);
            assertTrue(output().startsWith(ERROR_MESSAGE_PREFIX));
        });
    }

    @Test
    void 횟수가_음수인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game("pobi", -1);
            assertTrue(output().startsWith(ERROR_MESSAGE_PREFIX));
        });
    }

}