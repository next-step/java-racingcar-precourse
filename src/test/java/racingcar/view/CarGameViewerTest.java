package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarGameViewerTest {
    @Test
    void inputTest() {
        String input = "hello, yoordi";
        CarGameViewer carGameViewer = new CarGameViewer();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String userInput = carGameViewer.getCarNames();
        Assertions.assertEquals(input, userInput);
    }

    @Test
    void repeatInputTest() {
        String input = "3";
        CarGameViewer carGameViewer = new CarGameViewer();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String userInput = carGameViewer.getRepeatCount();
        Assertions.assertEquals(input, userInput);
    }
}
