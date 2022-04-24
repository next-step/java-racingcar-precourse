package racingcar;

import racingcar.model.game.GameMachine;
import racingcar.view.SystemOutputErrorView;

public class Application {

    public static void main(String[] args) {
        try {
            new GameMachine().start();
        } catch (Exception e) {
            SystemOutputErrorView.printError(e.getMessage());
        }
    }

}
