package racingcar.controller;

import racingcar.dto.ResultRacingCarsDTO;
import racingcar.service.RacingCarPlayService;
import racingcar.view.RacingCarGameInputView;
import racingcar.view.RacingCarGameResultView;
import racingcar.vo.RacingCars;

public class RacingCarGameController {

    private final RacingCarPlayService racingCarPlayService;
    private final RacingCarGameInputView racingCarGameInputView;
    private final RacingCarGameResultView racingCarGameResultView;

    public RacingCarGameController() {
        this.racingCarPlayService = new RacingCarPlayService();
        this.racingCarGameInputView = new RacingCarGameInputView();
        this.racingCarGameResultView = new RacingCarGameResultView();
    }

    public String startGameInputCarNamesMessage() {
        return racingCarGameInputView.startInputCarNamesMessage();
    }

    public ResultRacingCarsDTO registerRacingCars(String inputCarNames) {
        try {
            RacingCars racingCars = racingCarPlayService.registerRacingCars(inputCarNames);
            return new ResultRacingCarsDTO(racingCars, false);
        } catch (IllegalArgumentException e) {
            return new ResultRacingCarsDTO(true, e.getMessage());
        }
    }

    public String inputRoundMessage() {
        return racingCarGameInputView.inputRoundMessage();
    }

    public ResultRacingCarsDTO playRacingCarGame(RacingCars racingCars, String round) {
        try {
            RacingCars resultRacingCars = racingCarPlayService.proceedGame(racingCars, round);
            return new ResultRacingCarsDTO(resultRacingCars, false);
        } catch (IllegalArgumentException e) {
            return new ResultRacingCarsDTO(true, e.getMessage());
        }
    }

    public String allRoundResult(RacingCars racingCars) {
        return racingCarGameResultView.allRoundResultView(racingCars);
    }

    public String racingGameWinners(RacingCars racingCars) {
        return racingCarGameResultView.racingGameWinnersView(racingCars.getGameWinnerList());
    }
}
