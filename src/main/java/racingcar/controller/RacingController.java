package racingcar.controller;

import racingcar.domain.Winner;
import racingcar.service.RacingService;
import racingcar.util.Validation;
import racingcar.view.RacingView;

public class RacingController {
    RacingService racingService = new RacingService();
    RacingView racingView = new RacingView();
    Winner winner = new Winner();
    Validation validation = new Validation();

    public void startRacingGame() {
        racingService.init(setRacingCars());
        int inputRound = setRacingRound();

        for (int i = 0; i < inputRound; i++) {
            racingService.round();
            racingView.printRacingResult(racingService.getRacingCars());
        }

        winner.getWinnerCars(racingService.getRacingCars().getCarList());
        racingView.printOutWinnerCars(winner.getWinnerCars());
    }

    private int setRacingRound() {
        try {
            String inputRacingRound = racingView.printInputRound();
            validation.validationRound(inputRacingRound);
            return Integer.parseInt(inputRacingRound);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return setRacingRound();
        }
    }

    private String setRacingCars() {
        try {
            String inputCarName = racingView.printInputCarName();
            validation.validationCarName(inputCarName);
            return inputCarName;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return setRacingCars();
        }

    }
}
