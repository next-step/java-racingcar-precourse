package racinggame;

import racinggame.view.GameConsole;

public class Application {
    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole();

        gameConsole.setup();
        gameConsole.playGame();
    }
}
