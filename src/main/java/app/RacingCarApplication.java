package app;

import app.controller.GameExecutor;
import app.model.RacingCarGame;
import app.view.GameInterface;

public class RacingCarApplication {
    public static void main(String[] args) {
        GameExecutor gameExecutor = new GameExecutor(new GameInterface(), new RacingCarGame());
        gameExecutor.exec();
    }
}
