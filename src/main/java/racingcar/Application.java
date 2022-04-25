package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.RacingGame;
import racingcar.view.ReadyView;
import racingcar.view.StartView;

public class Application {
    public static void main(String[] args) {
        RacingController controller = new RacingController(
                new ReadyView(), new StartView()
        );
        RacingGame racingGame = controller.readyRacing();
        controller.startRacing(racingGame);
    }
}
