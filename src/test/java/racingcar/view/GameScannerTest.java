package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class GameScannerTest {

    @Test
    void testScanGameRounds() {
        String input = "3";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int rounds = GameScanner.scanGameRounds();
        assertEquals(Integer.parseInt(input), rounds);
    }

    // racing car 이름이 같을 때
    @Test
    @DisplayName("Racing Car 의 이름이 같다면 다시 입력하도록 한다.")
    void testDuplicateRacingCarName() {

    }
}