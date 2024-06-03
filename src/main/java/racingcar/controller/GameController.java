package racingcar.controller;

import racingcar.Utils_and_Message.ViewMessage;
import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private RacingCar racingCar;
    private int gameRound;

    public GameController() {
        racingCar = InputController.setRacingCars();
        gameRound = Integer.parseInt(InputView.roundInput());
        OutputView.printMessage(ViewMessage.GAME_RESULT);
        for(int i= 0; i< gameRound; i++){
            racingCar.playRound();
        }
        OutputView.printWinner(racingCar.findWinner());
    }
}
