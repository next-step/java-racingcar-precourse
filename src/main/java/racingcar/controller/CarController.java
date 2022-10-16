package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.view.GameView;

public class CarController {
    private final GameFactory gameFactory;
    private GamePlayer gamePlayer;

    public CarController(GameFactory gameFactory){
        this.gameFactory = gameFactory;
    }

    public void start(){
        GameView.showMessages(GameView.NAME_REQUEST.getMessage());
        Cars cars = gameFactory.makeCars(Console.readLine());
        GameView.showMessages(GameView.PLAYTIME_REQUEST.getMessage());
        this.gamePlayer = gameFactory.startGame(Console.readLine());

        play(cars);
    }
    public void play(Cars cars){
        GameView.showMessages(gamePlayer.racingProgress(gamePlayer.play(cars)));
        GameView.showResult(gamePlayer.findWinnerNames(cars));
    }
}
