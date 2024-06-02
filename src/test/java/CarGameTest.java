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

    @Test
    public void testDetermineWinners() {
        ArrayList<String> carList = new ArrayList<>();
        carList.add("car1");
        carList.add("car2");
        int[] forwardMovementCountArray = {3, 5};

        ArrayList<String> winners = CarGame.determineWinners(carList, forwardMovementCountArray);
        assertEquals(1, winners.size());
        assertEquals("car2", winners.get(0));
    }

    @Test
    public void testGetMaxForwardMovement() {
        int[] forwardMovementCountArray = {3, 5, 2};
        int max = CarGame.getMaxForwardMovement(forwardMovementCountArray);
        assertEquals(5, max);
    }

    @Test
    public void testPrintWinners() {
        ArrayList<String> winners = new ArrayList<>();
        winners.add("car1");
        winners.add("car2");

        CarGame.printWinners(winners);
    }
}
