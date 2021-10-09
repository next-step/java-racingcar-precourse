package controller;

import model.Car;
import service.GameService;

public class GameController {
    private Car car;
    private GameService gameService;

    public GameController() {
        car = new Car();
        gameService = new GameService( car );
    }

    public void start() {
        gameService.initialize();
    }
}
