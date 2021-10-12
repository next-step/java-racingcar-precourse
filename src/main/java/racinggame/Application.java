package racinggame;

import racinggame.control.GameController;
import racinggame.control.GameStatus;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        GameController game = new GameController();
        while (game.getCurrentInfo().getStatus() != GameStatus.EXIT) {
            game.run();
        }
    }
}
