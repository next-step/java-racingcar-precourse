package racingcar;

import racingcar.controller.RaceingcarController;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class Application {
    public static void main(String[] args) {
        RaceingcarController racingcarController =
                new RaceingcarController(new InputView(), new OutPutView());

        racingcarController.start();
    }
}
