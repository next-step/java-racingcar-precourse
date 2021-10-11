package racinggame.controller;

import racinggame.service.RacingGameService;
import racinggame.utils.CarsName;
import racinggame.utils.Chances;
import racinggame.utils.Result;
import racinggame.utils.Winner;
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
    }

    public void racing(int chances, Result result) {
        System.out.println("\n실행결과");
        while (chances != 0) {
            racingGameService.moveCar(result);
            user.printResult(result);
            chances--;
        }
        Winner wiiner = racingGameService.findWinner(result);
        user.printWinner(wiiner);
    }
}
