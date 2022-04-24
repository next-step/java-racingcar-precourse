package racingcar;

import racingcar.controller.FrontController;
import racingcar.controller.PlayController;

public class Application {
    public static void main(String[] args) {
        FrontController pc = new FrontController();
        pc.start();
    }
}
