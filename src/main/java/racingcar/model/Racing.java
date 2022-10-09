package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.RacingArgument;
import racingcar.view.RacingProgress;

import static racingcar.view.RacingArgument.printErrorMessage;
import static racingcar.view.RacingProgress.printBlankOneLine;

public class Racing {

    private final RacingArgument racingArgument = new RacingArgument();
    private final RacingProgress racingProgress = new RacingProgress();

    private final int ADVANCE_COUNT = 4;

    private final int RANDOM_MIN_COUNT = 0;
    private final int RANDOM_MAX_COUNT = 9;

    private RacingCars racingCars;
    private RoundNumber roundNumber;
    private WinCars winCars;

    public void startGame() {
        initRacingCars();
        initRacingRoundNumber();
        startRacing();
    }

    private void initRacingCars() {
        try {
            this.racingCars = racingArgument.inputRacingCars();
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            initRacingCars();
        }
    }

    public void initRacingRoundNumber() {
        try {
            this.roundNumber = racingArgument.inputRacingRoundNumber();
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            initRacingRoundNumber();
        }
    }

    private void startRacing() {
        racingProgress.printExecutionResult();
        for (int i = 1; i <= roundNumber.getRoundNumber(); i++) {
            startRacingEachRound();
        }
        generatorWinCarsByRacingResult();
        racingProgress.printFinalRacingResult(winCars);
    }

    private void startRacingEachRound() {
        for (Car car : racingCars.getRacingCars()) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_COUNT, RANDOM_MAX_COUNT);
            calcAdvanceCountByRandomNumber(car, randomNumber);
            racingProgress.printRacingResultEachCar(car);
        }
        printBlankOneLine();
    }

    private void generatorWinCarsByRacingResult() {
        WinCars winCars = new WinCars();
        winCars.generatorWinCars(racingCars);
        this.winCars = winCars;
    }

    public void calcAdvanceCountByRandomNumber(Car car, int number) {
        if (number >= ADVANCE_COUNT) {
            car.addedAdvanceCount();
        }
    }

}
