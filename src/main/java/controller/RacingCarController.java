package controller;

import domain.RacingCarModel;
import domain.RacingCarService;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void createRacingCar(RacingCarRequest.CreateCarRequest createCarRequest) {
        racingCarService.createRacingCar(createCarRequest.toCommand());
    }

    public RacingCarResponse.ResultGameResponse playRacing(
        RacingCarRequest.RacingRoundRequest racingRoundRequest) {
        int racingRound = racingRoundRequest.round();
        racingCarService.playRacing(racingRound);
        RacingCarModel.GameResult gameResult = racingCarService.getGameResult();
        return RacingCarResponse.ResultGameResponse.from(gameResult);
    }

}
