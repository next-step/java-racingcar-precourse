package racinggame;

import racinggame.controller.GameController;

public class Application {
    private static final GameController GAME_CONTROLLER = new GameController();

    public static void main(String[] args) {
        GAME_CONTROLLER.play();
    }
}
