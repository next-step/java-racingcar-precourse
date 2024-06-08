import java.util.List;

public class PlayRace {
    public static void playRace(List<String> carNames, int numberOfRounds, List<Integer> positions) {
        for (int i = 0; i < numberOfRounds; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                MoveOrNot.moveOrNot(positions, j);
            }
            ShowRoundResults.showRoundResults(carNames, positions);
        }
    }

}
