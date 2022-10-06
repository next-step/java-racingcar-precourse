package controller;

import domain.Car;
import service.GameService;

public class GameController {

    GameService gameService = new GameService();


    public void run(){
        gameService.setGame();
        gameService.playGame();
        gameService.endGame();
    }
}
