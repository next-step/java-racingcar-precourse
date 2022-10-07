package racingcar.controller;

import racingcar.service.GameService;
import racingcar.service.GameServiceImpl;

public class GameController {

    private final GameService gameService;

    public GameController(){
        gameService = new GameServiceImpl();
    }

    public void playGame(){
        while (!gameService.play()){
            gameService.showScore();
        }

        gameService.gameEnd();
    }
}
