package racingcar.ui;

import racingcar.domain.Cars;
import racingcar.domain.Game;

public class ResultView {
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자: ";

    public static void printWinners(Game game) {
        Cars winners = game.getWinners();
        System.out.println(WINNER_ANNOUNCEMENT + winners.getNamesWithComma());
    }

}
