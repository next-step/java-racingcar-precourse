package controller;

import service.GameService;
import util.RandomGenerator;

public class GameController {

    private final GameService gameService;
    public static RandomGenerator randomGenerator;

    public GameController() {
        this.gameService = new GameService(randomGenerator);
    }

    public void playGame() {

    }

}
