package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController();
            gameController.play();
        } catch (Exception e) {
            System.out.println("[ERROR]"+e.getMessage());
        }
    }
}
