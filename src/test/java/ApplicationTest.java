import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    @Test
    public void testMain() {
        // Arrange
        String input = "pobi,woni,jun\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        Application.main(new String[]{});

        // Assert
        String[] lines = out.toString().split("\n");
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", lines[0]);
        assertTrue(lines[1].startsWith("pobi"));
        assertTrue(lines[2].startsWith("woni"));
        assertTrue(lines[3].startsWith("jun"));
        assertTrue(lines[4].startsWith("최종 우승자"));
    }
}