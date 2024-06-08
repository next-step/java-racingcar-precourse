import java.util.List;

public class ShowRoundResults {
    public static void showRoundResults(List<String> carNames, List<Integer> positions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(positions.get(i)));
        }
        System.out.println();
    }

}
