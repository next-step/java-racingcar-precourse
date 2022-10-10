package racingcar.controller;

import java.util.List;
import racingcar.dto.GameHistories;
import racingcar.dto.GameResult;
import racingcar.model.Cars;
import racingcar.model.GameRound;
import racingcar.service.RacingCarGameService;
import racingcar.view.outputView;

public class RacingCarGameController  {

    private RacingCarGameService racingCarGameService;

    public RacingCarGameController(RacingCarGameService racingCarGameService) {
        this.racingCarGameService = racingCarGameService;
    }

    public void start() {
        Cars cars = racingCarGameService.gameCars();
        GameRound gameRound = racingCarGameService.gameRounds();
        List<GameHistories> gamePlayHistories = racingCarGameService.gamePlay(cars, gameRound);
        outputView.outputGamePlayHistories(gamePlayHistories);
        GameResult gameResult = racingCarGameService.gameWinners(cars);
        outputView.outputGamerWinners(gameResult);
    }
}
