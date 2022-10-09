package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import racingcar.model.laps.Laps;

public class ConsoleLapsReadTest {
    @Test
    void 콘솔_입력_진행_횟수_생성() {
        int expected = 123;
        this.setInput(String.valueOf(expected));

        Laps laps = ConsoleLaps.createLaps();
        int actual = laps.get();

        assertEquals(expected, actual);
    }

    @Test
    void 콘솔_입력_예외_공백() {
        String[] errorStrings = new String[]{""};
        this.assertNotAcceptableStringsThrowException(errorStrings, NoSuchElementException.class);
    }

    private <T extends Exception> void assertNotAcceptableStringsThrowException(String[] errorStrings, Class<T> e) {
        for (String errorString : errorStrings) {
            this.setInput(errorString);
            assertThatThrownBy(() -> ConsoleLaps.read()).isInstanceOf(e);
        }
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
