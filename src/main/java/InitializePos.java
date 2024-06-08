import java.util.ArrayList;
import java.util.List;

public class InitializePos {
    public static List<Integer> initializePos(int size) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            positions.add(0);
        }
        return positions;
    }
}
