import java.util.List;
import java.util.Random;

public class MoveOrNot {
    public static void moveOrNot(List<Integer> positions, int index) {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            positions.set(index, positions.get(index) + 1);
        }
    }
}
