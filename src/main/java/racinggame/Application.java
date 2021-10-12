package racinggame;

import racinggame.controller.GameConsoleController;

public class Application {
    public static void main(String[] args) {
        GameConsoleController gameConsoleController = new GameConsoleController();

        gameConsoleController.setup();
        gameConsoleController.playGame();
    }
}
