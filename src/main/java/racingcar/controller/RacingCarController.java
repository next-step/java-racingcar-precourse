package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingRound;
import racingcar.view.RacingView;

public class RacingCarController {
    private final RacingView racingView;

    public RacingCarController(RacingView racingView) {
        this.racingView = racingView;
    }

    public void doRacing() {
        RacingCars racingCars = getRacingCarsByUserInput();
        RacingRound racingRound = getRacingRoundByUserInput();
        movePerRoundAndPrintCarOffset(racingCars, racingRound);
        racingView.printRacingWinners(racingCars);
    }

    private void movePerRoundAndPrintCarOffset(RacingCars racingCars, RacingRound racingRound) {
        racingView.printPrepareRacing();
        for (int i = 0; i < racingRound.getRound(); i++) {
            racingCars.moveAll();
            racingView.printRacingCarsOffset(racingCars);
        }
    }

    private RacingRound getRacingRoundByUserInput() {
        racingView.printInputNumberOfAttempts();
        String round = Console.readLine();
        try {
            return RacingRound.of(round);
        } catch (IllegalArgumentException exception) {
            racingView.printExceptionMessage(exception);
        }
        return getRacingRoundByUserInput();
    }

    private RacingCars getRacingCarsByUserInput() {
        racingView.printInputCarNames();
        try {
            return RacingCars.of(getNamesByUserInput());
        } catch (IllegalArgumentException exception) {
            racingView.printExceptionMessage(exception);
        }
        return getRacingCarsByUserInput();
    }

    private List<String> getNamesByUserInput() {
        String names = Console.readLine();
        return Arrays.asList(names.split(","));
    }
}
