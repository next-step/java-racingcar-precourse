package racingcar.view;

import racingcar.game.dto.RacingResult;

import java.util.List;

public class RacingResultOutView {

    public static void racingResult(List<RacingResult> racingResults) {
        for (RacingResult result : racingResults) {
            StringBuilder position = new StringBuilder();
            for (int index = 0; index < result.getPosition(); index++) {
                position.append("-");
            }
            System.out.println(result.getName() + " : " + position);
        }
        System.out.println();
    }
}
