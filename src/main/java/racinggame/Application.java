package racinggame;

import racinggame.control.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        GameController game = new GameController();
        while (true) {
            game.run();
        }
    }
}
