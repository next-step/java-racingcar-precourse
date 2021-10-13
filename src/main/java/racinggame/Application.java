package racinggame;

import controller.GameController;

public class Application {

    private GameController gameController;

    public Application() {
        gameController = new GameController();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.gameStart();
    }

    private void gameStart() {
        gameController.start();
    }
}
