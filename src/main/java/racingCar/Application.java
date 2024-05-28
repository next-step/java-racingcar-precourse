package racingCar;

import racingCar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarGame = new RacingCarController();
        racingCarGame.doGame();
    }
}
