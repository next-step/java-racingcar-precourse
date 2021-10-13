package racinggame.controller;

import racinggame.domain.CarsName;
import racinggame.domain.Chances;
import racinggame.domain.RacingResult;
import racinggame.service.RacingGameService;
import racinggame.view.User;

public class RacingGameController {
    private User user;
    private RacingGameService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingGameService();
        this.user = new User();
    }

    public void gameStart() {
        CarsName carsName = user.askCarsName();
        Chances chances = user.askChances();
        racingGameService.makeCars(carsName.carsName);
        RacingResult racingResult = racingGameService.setRacingCar();
        racing(chances.chances, racingResult);
        user.printWinner(racingGameService.findWinner(racingResult));
    }

    public void racing(int chances, RacingResult racingResult) {
        user.printRacingResultStartMsg();
        while (chances != 0) {
            racingGameService.moveCar(racingResult);
            user.printRacingResult(racingResult);
            chances--;
        }
    }
}
