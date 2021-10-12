package racinggame.controller;

import racinggame.domain.CarsName;
import racinggame.domain.Chances;
import racinggame.domain.Result;
import racinggame.service.RacingGameService;
import racinggame.view.User;

public class RacingGameController {
    private User user;
    public RacingGameService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingGameService();
        this.user = new User();
    }

    public void gameStart() {
        CarsName carsName = user.askCarsName();
        Chances chances = user.askChances();
        racingGameService.makeCars(carsName.carsName);
        Result result = racingGameService.makeCar();
        racing(chances.chances, result);
        user.printWinner(racingGameService.findWinner(result));
    }

    public void racing(int chances, Result result) {
        user.printRacingResultMsg();
        while (chances != 0) {
            racingGameService.moveCar(result);
            user.printRacingResult(result);
            chances--;
        }
    }
}
