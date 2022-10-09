package racingcar.view;

import racingcar.game.dto.WinnerResult;

import java.util.List;

public class WinnerOutView {

    public static void racingResult(List<WinnerResult> winnerResults) {
        String winner = "";
        for (int index = 0; index < winnerResults.size() - 1; index++) {
            winner += winnerResults.get(index).getCarName() + ",";
        }
        winner += winnerResults.get(winnerResults.size() - 1).getCarName();
        System.out.println(String.format("최종 우승자 : %s ", winner));

    }
}
