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

    @Test
    public void testRunRace() {
        ArrayList<String> carList = new ArrayList<>();
        carList.add("car1");
        carList.add("car2");
        int gameCount = 5;

        int[] result = CarGame.runRace(carList, gameCount);
        assertEquals(2, result.length);
    }
}
