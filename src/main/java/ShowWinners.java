import java.util.ArrayList;
import java.util.List;

public class ShowWinners {
    public static void showWinners(List<String> carNames, List<Integer> positions) {
        int maxPos = positions.stream().mapToInt(pos -> pos).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            if (positions.get(i) == maxPos) {
                winners.add(carNames.get(i));
            }
        }
        System.out.println("우승자: " + String.join(", ", winners));
    }
}
