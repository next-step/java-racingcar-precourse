package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsoleCarNamesWriteTest {
    private OutputStream out;

    @BeforeEach
    protected final void init() {
        this.out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void 콘솔_출력_횟수_질의() {
        ConsoleCarNames.printRequest();
        assertThat(out.toString()).isEqualTo(ConsoleCarNames.REQUEST_MESSAGE.toString());
    }

    @Test
    void 콘솔_출력_예외_메시지() {
        ConsoleCarNames.printException();
        assertThat(out.toString()).contains(ConsoleCarNames.EXCEPTION_MESSAGE_PREFIX.toString());
    }
}
