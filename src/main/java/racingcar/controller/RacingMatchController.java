package racingcar.controller;

import racingcar.model.CarNames;
import racingcar.model.PlayerInput;
import racingcar.model.RacingCars;
import racingcar.model.RacingMatch;

public class RacingMatchController {
    private final PlayerInput playerInput;

    public RacingMatchController(PlayerInput playerInput) {
        this.playerInput = playerInput;
    }

    public RacingMatch process() {
        RacingCars racingCars = toRacingCars(playerInput.getCarNames());
        return new RacingMatch(racingCars, playerInput.getLap());
    }

    private RacingCars toRacingCars(CarNames carNames) {
        return new RacingCars(carNames);
    }
}
