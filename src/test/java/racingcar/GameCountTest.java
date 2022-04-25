package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.GameCount;
import racingcar.view.Message;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameCountTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    void 시도_횟수는_숫자여야_합니다() {
        System.setOut(new PrintStream(outputStreamCaptor));
        GameCount gameCount = new GameCount();
        gameCount.setGameCount("test");
        assertEquals(Message.getGameCountMustBeDigits(), outputStreamCaptor.toString()
                .trim());
    }
}
