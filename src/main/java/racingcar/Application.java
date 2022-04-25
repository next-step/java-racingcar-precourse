package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        try {
            RacingCarController racingCarController = new RacingCarController();
            racingCarController.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
