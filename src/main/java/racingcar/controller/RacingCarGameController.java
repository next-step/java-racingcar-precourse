package racingcar.controller;

import racingcar.dto.ResultRacingCarsDTO;
import racingcar.service.RacingCarPlayService;
import racingcar.view.RacingCarGameInputView;
import racingcar.vo.RacingCars;

public class RacingCarGameController {

    private final RacingCarPlayService racingCarPlayService;
    private final RacingCarGameInputView racingCarGameInputView;

    public RacingCarGameController() {
        this.racingCarPlayService = new RacingCarPlayService();
        this.racingCarGameInputView = new RacingCarGameInputView();
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
}
