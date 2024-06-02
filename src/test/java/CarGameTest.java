import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarGameTest {
    @Test
    public void testGetGameCount() {
        String input = "5\n";
        Scanner sc = new Scanner(input);
        int gameCount = CarGame.getGameCount(sc);

        assertEquals(5, gameCount);
    }
}
