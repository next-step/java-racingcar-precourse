package racingcar.controller;

import racingcar.model.*;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarOutput;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final RacingCarService racingCarService;

    public RacingCarGame(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void startGame() {
        List<CarName> carNames = inputRacingCarName();
        ResultView result = racingCarService.race(carNames, getAttemptCount());
        getResult(result);
    }

    private void getResult(ResultView result) {
        RacingCarView.printRaceResult(result);
        RacingCarView.printFinalWinner(racingCarService.findFinalWinner());
    }

    private AttemptCount getAttemptCount() {
        AttemptCount attemptCount;
        try {
            attemptCount = new AttemptCount(inputAttemptCount());
        } catch (IllegalArgumentException e) {
            RacingCarOutput.println(e.getMessage());
            return getAttemptCount();
        }

        return attemptCount;
    }

    private List<CarName> inputRacingCarName() {
        List<CarName> carNames;
        try {
            carNames = Delimiter.separateCarNames(RacingCarView.inputRacingCarName());
        } catch (IllegalArgumentException e) {
            RacingCarOutput.println(e.getMessage());
            return inputRacingCarName();
        }

        return carNames;
    }

    private String inputAttemptCount() {
        return RacingCarView.inputAttemptCount();
    }
}
