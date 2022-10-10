package racingcar;

import racingcar.controller.RacingMatchController;
import racingcar.model.PlayerInput;
import racingcar.model.RacingMatch;
import racingcar.view.RacingMatchView;

public class Application {
    public static void main(String[] args) {
        RacingMatchView racingMatchView = new RacingMatchView(RacingMatch.START);
        PlayerInput playerInput = racingMatchView.askForPlayerInput();

        RacingMatchController racingMatchController = new RacingMatchController(playerInput);
        RacingMatch racingMatch = racingMatchController.process();

        racingMatchView = new RacingMatchView(racingMatch);
        racingMatchView.printResult();
    }
}
