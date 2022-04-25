package racingcar.ui;

import racingcar.domain.Cars;
import racingcar.domain.Referee;

public class OutputView {

    private static final String PRINT_WINNERS_PREFIX = "최종 우승자: ";

    public static void finishRacing(Cars racingFinishCars) {
        Referee referee = new Referee(racingFinishCars);
        Cars racingWinner = referee.getWinners();
        String printWinners = PRINT_WINNERS_PREFIX + racingWinner.getCarNames();
        System.out.print(printWinners);
    }

}
