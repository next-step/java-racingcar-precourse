package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
		ConsoleView consoleView = new ConsoleView();
		new RacingGameController(consoleView).startGame();
    }
}
